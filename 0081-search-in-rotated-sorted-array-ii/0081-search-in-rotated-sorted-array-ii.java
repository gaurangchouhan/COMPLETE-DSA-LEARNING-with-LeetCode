class Solution {
    public boolean search(int[] nums, int target) {
        return bs(nums, target);
    }

    public boolean bs(int[] a, int t){
        int n = a.length;
        int low = 0;
        int high = n-1;

        boolean found = true;
        if(a[low] > t){
            found = false;
        }

        if(!found){
            while(low < n && a[low] <= t){
                low++;
            }
        }else{
            while(high >= 0 && a[high] > t){
                high--;
            }
        }

        while(low <= high){
            int mid = (low + high) / 2;


            if(a[mid] == t){
                return true;
            }

            if(a[low] == a[mid] && a[mid] == a[high]){
                low++;
                high--;
                continue; 
            }

            if (a[low] <= a[mid]) {
                if (t >= a[low] && t < a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (t > a[mid] && t <= a[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
// Concept: binary search 
// Time complexity: O(logN)
// Space complexity: O(1)