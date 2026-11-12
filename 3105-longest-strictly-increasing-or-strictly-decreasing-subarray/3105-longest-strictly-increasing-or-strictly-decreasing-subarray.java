class Solution {
    public int longestMonotonicSubarray(int[] a) {
        
        int n = a.length;

        int size = 1;

        for(int i=0; i<n; i++){

            for(int j=i+1; j<n; j++){
                if(a[j-1] < a[j]){
                    size = Math.max(size, j-i+1);
                }else{
                    break;
                }
            }

            for(int k=i+1; k<n; k++){
                if(a[k-1] > a[k]){
                    size = Math.max(size, k-i+1);
                }else{
                    break;
                }
            }
        }
        return size;
    }
}

// TC: O(2*(n^2))
// SC: O(1)