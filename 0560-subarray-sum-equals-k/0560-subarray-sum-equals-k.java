class Solution {
    public int subarraySum(int[] a, int k) {
        int n = a.length;
        int count = 0;
        // ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += a[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}