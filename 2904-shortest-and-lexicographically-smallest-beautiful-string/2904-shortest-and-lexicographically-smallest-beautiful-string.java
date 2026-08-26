class Solution {
    // 604 / 674 testcases passed
    public String shortestBeautifulSubstringBruteForce(String s, int k) {
        int n = s.length();
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(equalK(s, i, j, k)){
                    int len = j-i+1;
                    if(len < minLen){
                        minLen = len;
                        ans = s.substring(i, j+1);
                    }
                }else{
                    continue;
                }
            }
        }
        return ans;
    }

    public boolean equalK(String s, int i, int j, int k){
        int n = s.length();
        int cnt0 = 0;
        int cnt1 = 0;
        int sum = 0;
        for (int l = i; l <= j; l++) {
            if(s.charAt(l)=='0') {
                cnt0++;
            }else{
                cnt1++;
            }
            sum += s.charAt(l) - '0';
        }
        int storeCnt0 = cnt0;
        return (sum == k && cnt1>cnt0);
    }

    public String shortestBeautifulSubstring(String s, int k) {

        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                pos.add(i);
            }
        }

        if (pos.size() < k)
            return "";

        String ans = "";

        for (int i = 0; i + k - 1 < pos.size(); i++) {

            int start = pos.get(i);
            int end = pos.get(i + k - 1);

            String cur = s.substring(start, end + 1);

            if (ans.isEmpty() ||
                cur.length() < ans.length() ||
                (cur.length() == ans.length() && cur.compareTo(ans) < 0)) {

                ans = cur;
            }
        }

        return ans;
    }
}