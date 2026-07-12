class Solution {
    // MY LOGIC
    public int removeElement(int[] a, int val) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            if (a[left] == val && a[right] == val) {
                right--;
            } else if (a[left] != val && a[right] != val) {
                left++;
            } else if (a[left] == val) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            } else {
                right--;
            }
        }

        return left;
    }

    // Perplexity logic 
    // public int removeElement(int[] nums, int val) {
    //     int left = 0;
    //     int right = nums.length - 1;

    //     while (left <= right) {
    //         if (nums[left] == val) {
    //             nums[left] = nums[right];
    //             right--;
    //         } else {
    //             left++;
    //         }
    //     }
    //     return left;
    // }
}