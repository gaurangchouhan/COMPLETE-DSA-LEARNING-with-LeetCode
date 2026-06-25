import java.util.Vector;
class Solution {
    public void moveZeroes(int[] a) {
        int n = a.length;
        Vector<Integer> a1 = new Vector<>();

        for (int j : a) {
            if (j != 0) {
                a1.add(j);
            }
        }

        int nz = a1.size();
        for(int i = 0; i<nz;i++) {
            a[i] = a1.get(i);
        }

        for(int i = nz; i<n;i++) {
            a[i] = 0;
        }
        System.out.println(a);
    }
}