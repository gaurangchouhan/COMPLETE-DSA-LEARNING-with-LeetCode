class Solution {
    public int maxProductBetter(int[] a) {
        int n = a.length;
        int maxProduct = Integer.MIN_VALUE;

        if(n==1){
            return a[0];
        }
        if(n==2){
            int max = Math.max(a[0], a[1]);
            int subarray = a[0]*a[1];
            return Math.max(max, subarray);
        }

        for(int i=0; i<n; i++){
            int product = 1;
            for(int j=i; j<n; j++){
                product *= a[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1) 

    public int maxProduct(int[] a){
        int n = a.length;
        int maxProduct = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for(int i=0; i<n; i++){
            if(prefix == 0){
                prefix = 1;
            }

            if(suffix == 0){
                suffix = 1;
            }

            prefix *= a[i];
            suffix *= a[n-i-1]; 

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
}