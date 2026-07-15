class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        // left --> right --> bottom --> top Approach 

        int l=0, r=n-1;
        int t=0, b=m-1;

        List<Integer> list = new ArrayList<>();
        while (t<=b && l<=r){
            for (int i = l; i <= r; i++) {
                list.add(a[t][i]);
            }
            t++;

            for (int i = t; i <= b; i++) {
                list.add(a[i][r]);
            }
            r--;

            if (t<=b) {
                for (int i = r; i >= l; i--) {
                    list.add(a[b][i]);
                }
                b--;
            }

            if (l<=r) {
                for (int i = b; i >= t; i--) {
                    list.add(a[i][l]);
                }
                l++;
            }
        }
        return list;
    }
}

// Time Complexity: O(m*n)  (Because each loop visits one element once)
// Space Complexity: O(m*n)  (because we are using a list to store the elements)