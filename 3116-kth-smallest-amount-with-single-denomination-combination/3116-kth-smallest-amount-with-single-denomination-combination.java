class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int numSubsets = (1 << n) - 1;
        long[] lcms = new long[numSubsets];
        int[] signs = new int[numSubsets];
        int idx = 0;

        for (int i = 1; i < (1 << n); i++) {
            long curLcm = 1;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    count++;
                    curLcm = (curLcm / gcd(curLcm, coins[j])) * coins[j];
                }
            }
            lcms[idx] = curLcm;
            signs[idx] = (count % 2 == 1) ? 1 : -1;
            idx++;
        }

        long minCoin = coins[0];
        for (int c : coins) {
            if (c < minCoin) minCoin = c;
        }

        long left = 1;
        long right = minCoin * k;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long cnt = 0;
            for (int i = 0; i < numSubsets; i++) {
                cnt += signs[i] * (mid / lcms[i]);
            }
            
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

// Concept: GCD and Binary Search 

// Time complexity:
/* 
   Precomputing the subsets takes = O(n⋅2^n * log(max_val)) (due to LCM calculations). 
   The binary search takes = O(2^n * log(min(coins)⋅k)).
   
   Overall Time Complexity: O(2^n * (n+log(min(coins)⋅k)))
*/
   
// Space complexity:
/*
    We store exactly (2^n−1) subsets.
    Overall Space Complexity: O(2^n)
*/