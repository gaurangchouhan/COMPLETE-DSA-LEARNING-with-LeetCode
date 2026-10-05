class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        int totalSubsets = 1 << n;

        List<List<Integer>> ans = new ArrayList<>();

        
        for(int val = 0; val < totalSubsets; val++) {
            List<Integer> subset = new ArrayList<>();

            
            for(int i = 0; i < n; i++) {
                if((val & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            ans.add(subset);
        }

        return ans;
    }
}

// Time complexity: O(N × 2^N)
// Space complexity: O(N × 2^N)
