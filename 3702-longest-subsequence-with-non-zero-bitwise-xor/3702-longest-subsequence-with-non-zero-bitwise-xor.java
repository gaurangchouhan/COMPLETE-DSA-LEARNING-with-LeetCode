class Solution {
    public int longestSubsequence(int[] a) {
        int n = a.length;
        int len = Integer.MIN_VALUE;
        int xor = 0;
        boolean notZero = false;

        for(int i=0; i<n; i++){
            xor ^= a[i];
            if(a[i] != 0){
                notZero = true;
            }
        }
        
        if(!(notZero)){
            return 0;
        }
        else if(xor != 0){
            return n;
        }
        return (n-1);
    }
}

// Concept: XOR Gate
// Time complexity: O(n)
// Space complexity: O(1) 