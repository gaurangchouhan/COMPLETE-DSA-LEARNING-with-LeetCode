class Solution {
    public int[] twoSum(int[] a, int t) {
        int n = a.length;
        int[] arr = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = t-a[i];
            if (hm.containsKey(k)){
                arr[0] = hm.get(k);
                arr[1] = i;
            }else {
                hm.put(a[i], i);
            }
        }
        return arr;
    }
}