import java.util.Vector;
class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        // This code passed 2064/2099 test cases. 
        // int n = a.length;
        // int m = b.length;
        
        // double min = Integer.MAX_VALUE;
        // double max = Integer.MIN_VALUE;

        // for (int i = 0; i < n; i++) {
        //     if (a[i]<min){
        //         min = Math.min(min, a[i]);
        //     }
        //     if (a[i]>max){
        //         max = Math.max(max, a[i]);
        //     }
        // }

        // for (int i = 0; i < m; i++) {
        //     if (b[i]<min){
        //         min = Math.min(min, b[i]);
        //     }
        //     if (b[i]>max){
        //         max = Math.max(max, b[i]);
        //     }
        // }
        
        // return (max+min)/2;

        int n = a.length, m = b.length;
        int total = n + m;
        int mid = total / 2;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for (int count = 0; count <= mid; count++) {
            prev = curr;

            if (i < n && (j >= m || a[i] <= b[j])) {
                curr = a[i];
                i++;
            } else {
                curr = b[j];
                j++;
            }
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}