class Solution {
    // Brute Force Solution
    public int maxProduct(int[] a) {
        int n = a.length;
        int maxProduct = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int product = (a[i]-1)*(a[j]-1);
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    // Time Complexity: O(n^2)
    // Space complexity : O(1)

    // Optimal Solution
    public int maxProductOptimal(int[] nums) {
        int n = nums.length;
        int max1=0;
        int max2=0;
        for(int i=0; i<n; i++){
            if(nums[i]>max1){
                max2=max1;
                max1=nums[i];
            }
            else if(nums[i]>max2){
                max2=nums[i];
            }
        }
        return (max1 - 1)*(max2 -1);
    }
}

// Time Complexity: O(n)
// Space complexity : O(1)