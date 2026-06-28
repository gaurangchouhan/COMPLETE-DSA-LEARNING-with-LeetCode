class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] a) {
        int n = a.length;
        int[] b = new int[n+1];

        int ans = 1;

        for(int i=0; i<n; i++){
            b[Math.min(n, a[i])]++;
        }

        for(int i=2; i<n+1; i++){
            ans = Math.min(i,ans+b[i]);
        }
        return ans;
    }
}