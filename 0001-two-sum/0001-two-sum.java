class Solution {
    public int[] twoSum(int[] a, int t) {
        int n = a.length;
        // int[] result = new int[2];
        // int sum = 0;

        for(int i = 1; i<n; i++){
        for(int j = i; j<n; j++){
            if(a[j]+a[j-i]==t){
                return new int[] { j, j - i };
            }
        }
        }
        return null;
    }
}