class Solution {
    public List<Integer> findMissingElementsMethodII(int[] a) {
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

    public List<Integer> findMissingElements(int[] a){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = a.length;
        List<Integer> l = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(a[i]>max){
                max = a[i];
            }
            if(a[i]<min){
                min = a[i];
            }
        }
        // System.out.println(min + ", " + max);  debugging

        for (int i = min; i < max; i++) {
        int ele = i + 1;
        boolean found = false;

            for (int j = 0; j < n; j++) {
                if (a[j] == ele) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                l.add(ele);
            }
        }
        return l;
    }

    // Time complexity : O(n)     +    O((max-min).n)
    //                  max-min        2nd nested for loop 
    //                  for loop       find missing element

    // Space complexity : O(number of missing elements)
}