class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9L * num) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int low = 0;
            int high = 9;
            int digit = 0;

            // Find the largest digit <= the remaining sum
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (mid <= sum) {
                    digit = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            ans.append(digit);
            sum -= digit;
        }

        return ans.toString();
    }

    // Time complexity: O(num*log(high-low))
    // Space complexity: O(num)

    public String maxSumOfSquaresBetter(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num;i++){
            int digit=Math.min(9,sum);
            sb.append(digit);
            sum-=digit;
            
        }
        return sb.toString();
    }

    // Time complexity: O(num)
    // Space complexity: O(num)
}