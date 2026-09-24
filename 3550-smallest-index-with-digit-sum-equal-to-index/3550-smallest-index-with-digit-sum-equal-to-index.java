class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int idx = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int considerIdx = findSumOfDigit(nums[i], i);
            
            idx = Math.min(idx, considerIdx);
        }
        if(idx == 1001) return -1;
        return idx;
    }

    public int findSumOfDigit(int a, int idx){
        int copyA = a;
        int sum = 0;
        while (copyA > 0){
            int digit = copyA % 10;
            sum += digit;
            copyA /= 10;
        }

        if(sum == idx){
            return idx;
        }
        return 1001;
    }
}