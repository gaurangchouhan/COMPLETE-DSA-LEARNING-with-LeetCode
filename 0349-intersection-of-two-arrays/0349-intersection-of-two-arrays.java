class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
       for(int i : nums1)
           arr[i] = 1;

        int[] result = new int[1001];
        int idx = 0;
        for(int i : nums2){
            if(arr[i] == 1){
                arr[i] = 2;
                result[idx] = i;
                idx++;
            }
        }
        return Arrays.copyOf(result,idx);
    }
}