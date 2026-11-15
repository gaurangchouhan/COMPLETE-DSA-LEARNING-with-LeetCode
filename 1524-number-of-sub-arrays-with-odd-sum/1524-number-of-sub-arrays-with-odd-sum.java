class Solution {
    public int numOfSubarraysBruteForceSol(int[] a) {
        int n = a.length;

        long MOD = 1_000_000_007;
        long cntOddSumSubArr = 0;
        
        for(int i=0; i<n; i++){
            long sum = 0;
            for(int j=i; j<n; j++){
                sum += a[j];
                
                if(sum % 2 != 0){
                    cntOddSumSubArr = (cntOddSumSubArr + 1) % MOD;
                }
            }
        }

        return (int)cntOddSumSubArr;
    }

    // Time Complexity: (O(n^2))
    // Space Complexity: (O(1)

    public int numOfSubarrays(int[] arr) {

        long MOD = 1_000_000_007;

        long even = 1;
        long odd = 0;
        long ans = 0;

        int prefix = 0;

        for (int num : arr) {

            prefix += num;
            prefix %= 2;

            if (prefix == 1) {
                ans = (ans + even) % MOD;
                odd++;
            } else {
                ans = (ans + odd) % MOD;
                even++;
            }
        }

        return (int) ans;
    }

    // Time Complexity: (O(n2))
    // Space Complexity: (O(1)
}