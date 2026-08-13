class Solution {
    public int findMin(int[] nums) {
        return minElement(nums);
    }

    public int minElement(int[] a){
        int n = a.length;
        int low = 0;
        int high = n-1;

        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high)/2;

            if(a[low] <=  a[mid]){
                min = Math.min(min, a[low]);
                low = mid+1;
            }else{
                min = Math.min(min, a[mid]);
                high = mid-1;
            }
        }
        return min;
    }
}

// Concept: binary search  
// Time Complexity: O(logN)
// Space Complexity: O(1)