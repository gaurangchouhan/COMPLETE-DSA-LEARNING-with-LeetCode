class Solution {
    // My Thought My Solution (45 / 62 testcases passed)
    public boolean predictTheWinnerWRONG(int[] nums) {
        int n = nums.length;
        int p1 = 0, p2 = 0;
        if(nums[0]>nums[n-1]){
            p1 += nums[0];
        }else if(nums[0]<nums[n-1]){
            p1 += nums[n-1];
        }else{
            p1 += nums[n-1];
        }

        if(p1 == nums[0]){
            for(int i=1; i<n; i++){
                if(i%2==0) p1 += nums[i];
                else p2 += nums[i];
            }
        }else{
            for(int i=n-2; i>=0; i--){
                if(i%2==0) p1 += nums[i];
                else p2 += nums[i];
            }
        }
        if(p1 >= p2) return true;

        return false;
    }

// Time complexity: O(n)
// Space complexity: O(1)

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int diff = check(nums, 0, n - 1);
        return diff >= 0;
    }

    private int check(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int Left = nums[l] - check(nums, l + 1, r);
        int Right = nums[r] - check(nums, l, r - 1);
        return Math.max(Left, Right);
    }
}

// Time complexity: T(n)=2⋅T(n−1)+O(1) = O(2^n)
// Space complexity: O(1)