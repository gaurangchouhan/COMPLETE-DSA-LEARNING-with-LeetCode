class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length == 0){
            return -1;
        }
        
        // if(nums.length == 1 && nums[0]==target){
        //     return 0;
        // }else{
        //     return -1;
        // }


        return bs(nums, target);
    }


    public int bs(int[] a, int t){
        int n = a.length;
        int low = 0;
        int high = n-1;


        boolean found = true;
        int ans = -1;
        if(a[low] > t){
            found = false;
        }

        if(!found){
            while(low < n && a[low] < t){
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
                ans = mid;
                return ans;
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
        return -1;
    }
}

// Time complexity: O(logN)
// Space complexity: O(1)