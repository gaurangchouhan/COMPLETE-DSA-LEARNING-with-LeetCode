class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;

    k = k % l;

    int[] temp = new int[k];

    for(int i=0;i<k;i++){
        temp[i] = nums[l-k+i];
    }

    for(int i=l-1;i>=k;i--){
        nums[i] = nums[i-k];
    }

    for(int i=0;i<k;i++){
        nums[i] = temp[i];
    }
        System.out.println(nums);
    }
}