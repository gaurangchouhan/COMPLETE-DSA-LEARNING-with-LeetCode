class Solution {
    public int searchInsert(int[] a, int target) {
        int n = a.length;

        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low + high)/2;

            if(a[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}

// Time complexity: O(log2(n)) because of using binary search 
// Face Complexity: O(1)