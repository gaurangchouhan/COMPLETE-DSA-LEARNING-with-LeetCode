class Solution {

    // My Logic (713/721 test cases passed)

    // public int[] gcdValues(int[] a, long[] queries) {
    //     int n = a.length;
    //     long q = queries.length;

    //     long totalPairs = 1L * n * (n - 1) / 2;
        
    //     int[] gcdPairs = new int[(int) totalPairs];

    //     int k = 0;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             gcdPairs[k++] = GCD(a[i], a[j]);
    //         }
    //     }

    //     Arrays.sort(gcdPairs);

    //     int[] answer = new int[queries.length];

    //     for (int i = 0; i < queries.length; i++) {
    //         long idx = queries[i];
    //         if (idx >= 0 && idx < totalPairs) {
    //             answer[i] = gcdPairs[(int) idx];
    //         }
    //     }
    //     return answer;
    // }

    // private int GCD(int a, int b) {
    //     while (a>0 && b>0){
    //         if (a>b){
    //             a = a%b;
    //         }else {
    //             b = b%a;
    //         }
    //     }
    //     if (a==0){
    //         return b;
    //     }
    //     return a;
    // }

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        int[] cnt = new int[max + 1];

        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                cnt[i] += freq[j];
            }
        }

        long[] pairs = new long[max + 1];

        for (int g = max; g >= 1; g--) {

            long c = cnt[g];
            pairs[g] = c * (c - 1) / 2;

            for (int m = g + g; m <= max; m += g) {
                pairs[g] -= pairs[m];
            }
        }

        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + pairs[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long target = queries[i] + 1;

            int l = 1;
            int r = max;

            while (l < r) {

                int mid = (l + r) / 2;

                if (prefix[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            ans[i] = l;
        }

        return ans;
    }
}

// Time Complexity: O(MAX log MAX + Q log MAX)
// Space Complexity: O(MAX)