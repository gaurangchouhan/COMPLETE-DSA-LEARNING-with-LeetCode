class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return recursion(nums, 0, n-1, target);
    }

    public int recursion(int[] arr, int low, int high, int target){
        if (low > high){
            return -1;
        }
        int mid = (low + high)/2;

        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return recursion(arr, mid+1, high, target);
        }
        
        return recursion(arr, low, mid-1, target);
    }

    public int withoutRecursion(int[] arr, int low, int high, int target){

        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }

        return -1;
    }
}

// Time complexity : O(log2(n))
// Space complexity : O(1)