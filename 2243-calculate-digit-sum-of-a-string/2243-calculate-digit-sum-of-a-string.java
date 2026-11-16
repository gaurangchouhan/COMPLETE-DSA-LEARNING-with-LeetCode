
class Solution {
    public String digitSum(String s, int k) {

        int n = s.length();
        if (s.length() <= k) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int cntDigit = 0;

        for (int i = 0; i < n; i++) {

            sum += s.charAt(i) - '0';
            cntDigit++;

            if (cntDigit == k || i == n - 1) {
                sb.append(sum);

                sum = 0;
                cntDigit = 0;
            }
        }

        return digitSum(sb.toString(), k);
    }
}

// TC: O(2^n)
// SC: O(n/2)