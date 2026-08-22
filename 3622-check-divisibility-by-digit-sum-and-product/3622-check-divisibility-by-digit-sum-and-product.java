class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int copyN = n;
        while(copyN>0){
            int digit = copyN%10;
            sum += digit;
            product *= digit;
            copyN /= 10;
        }
        // debugging (it increases the space complexity)
        // System.out.println("sum = "+sum);
        // System.out.println("product = "+product);
        int ans = sum + product;

        return n % ans == 0;
    }
}

// Time Complexity: O(no. of digits)
// Space Complexity: O(1)