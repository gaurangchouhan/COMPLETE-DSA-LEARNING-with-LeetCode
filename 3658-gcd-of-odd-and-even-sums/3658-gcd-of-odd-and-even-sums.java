class Solution {

    // My Logic
    public int gcdOfOddEvenSums(int n) {

        int evenSum = 0;
        int oddSum = 0;
        int cntEven = 0;
        int cntOdd = 0;

        int num = 1;

        while (cntEven < n || cntOdd < n) {

            if (num % 2 == 0) {
                if (cntEven < n) {
                    evenSum += num;
                    cntEven++;
                }
            } else {
                if (cntOdd < n) {
                    oddSum += num;
                    cntOdd++;
                }
            }

            num++;
        }

        int GCD = 1;

        for (int i = 1; i <= Math.min(evenSum, oddSum); i++) {
            if (evenSum % i == 0 && oddSum % i == 0) {
                GCD = i;
            }
        }

        return GCD;
    }

    // Time complexity: O(n) + O(min(evenSum, oddSum)) 
    //                 while        for loop
    //                 loop

    // Space complexity: O(1)
    
    // Observation
    // public int gcdOfOddEvenSums(int n) {
    //     int evenSum = n*n;
    //     int oddSum = n*(n-1);
    //     return n;
    // }

    // Time complexity: O(1)
    // Space complexity: O(1)

}