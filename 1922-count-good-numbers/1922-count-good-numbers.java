class Solution {
    
    private static final long MOD = 1000000007L;

    private long BinaryExp(long base, long exponent) {
        long result = 1;
 
        while (exponent > 0) {

            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
 
            exponent /= 2;
        }
 
        return result;
    }

    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n/2);

        long evenPosition = BinaryExp(5, even);
        long oddPosition = BinaryExp(4, odd);

        return (int) ((evenPosition * oddPosition) % MOD);
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)