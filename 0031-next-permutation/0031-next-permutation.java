class Solution {

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: Find the breakpoint
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no breakpoint, reverse whole array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the next greater element from right
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 4: Reverse the remaining part
        reverse(nums, index + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}