class Solution {
    public List<Integer> findMissingElements(int[] a) {
        int n = a.length;

        List<Integer> l = new ArrayList<>();
        Arrays.sort(a);

        for(int i=1; i<n; i++){
            if(a[i]-a[i-1]==1){
                continue;
            }else{
                for (int j = a[i-1]; j < a[i]-1; j++) {
                    int x = j + 1;
                    l.add(x);
                }
                }
            }
        return l;
    }
}