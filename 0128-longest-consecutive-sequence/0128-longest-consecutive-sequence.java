class Solution {
    public int longestConsecutive(int[] nums) {
        // My Logic
        int n = nums.length;
        Arrays.sort(nums);
        int len = 1;
        int ans = 1;
        if(n==0){
            return 0;
        }
        int k = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]==k){
                continue;
            }
            else if(nums[i] == k+1){
                k = nums[i];
                len++;
            }
            else if (nums[i] != k+1){
                k = nums[i];
                len = 1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}

// Time Complexity: O(nlogn) +  O(n) = O(nlogn)
//                  (Sorting)  (Loop)

// Space Complexity: O(1) -> bcoz no extra space use in it