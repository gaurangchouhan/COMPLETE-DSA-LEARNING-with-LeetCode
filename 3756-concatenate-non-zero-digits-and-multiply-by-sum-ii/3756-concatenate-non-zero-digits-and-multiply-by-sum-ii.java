class Solution {
    static final int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        // int n = queries.length;
        // int[] oparr = new int[n];
        // int c =0;
        // for (int r = 0; r < n; r++) {
        //     int start = queries[r][c];
        //     int stop = queries[r][c+1];

        //     String substring = s.substring(start, stop+1);

            // MY THINKINK (little bit wrong)
            // long num = Long.parseLong(substring);

            // int x=0;
            // int sum=0;
            // int i=1;
            // while(num>0){
            //     long newNum = num % 10;
            //     num /=10;
            //     if(newNum == 0){ 
            //         continue;
            //     }
            //     sum += newNum;
            //     x += (newNum * i);
            //     i *=10;
            // }

            // long ans = x*sum;
            // if(ans>MOD){
            //     ans = ans %
            // }

            // long x = 0;
            // long sum = 0;

            // for (int i = 0; i < substring.length(); i++) {

            //     int digit = substring.charAt(i) - '0';

            //     if (digit == 0){
            //         continue;
            //     }
            //     sum += digit;
            //     x = (x * 10 + digit) % MOD;
            // }

        //     oparr[r] = (int) ((x * sum) % MOD);
        // }
        // return oparr;
    int n = s.length();

        // Store positions and digit values for non-zero digits only
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                posList.add(i);
                digitList.add(d);
            }
        }

        int k = posList.size();

        // Prefix sum of digits
        long[] prefSum = new long[k + 1];

        // Prefix concatenated value as a number modulo MOD:
        // prefNum[i] = value of digits [0..i-1]
        long[] prefNum = new long[k + 1];

        // Powers of 10 for fast concatenation
        long[] pow10 = new long[k + 1];
        pow10[0] = 1;
        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < k; i++) {
            int d = digitList.get(i);
            prefSum[i + 1] = prefSum[i] + d;
            prefNum[i + 1] = (prefNum[i] * 10 + d) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];

            int left = lowerBound(posList, l);      // first non-zero position >= l
            int right = upperBound(posList, r) - 1; // last non-zero position <= r

            if (left > right) {
                ans[qi] = 0;
                continue;
            }

            long sum = prefSum[right + 1] - prefSum[left];

            int len = right - left + 1;
            long x = prefNum[right + 1] - (prefNum[left] * pow10[len]) % MOD;
            if (x < 0) x += MOD;

            long res = (x * (sum % MOD)) % MOD;
            ans[qi] = (int) res;
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int upperBound(ArrayList<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}