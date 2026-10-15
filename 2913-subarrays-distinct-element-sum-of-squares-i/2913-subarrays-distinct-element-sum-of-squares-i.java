class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;
        for(int i=0;i<n;i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<n;j++) {
                set.add(nums.get(j));
                int m = set.size();
                sum += (m*m);
            }
        }
        return sum;
    }
}

// Time complexity:O(n^2)
// Space complexity:O(n)