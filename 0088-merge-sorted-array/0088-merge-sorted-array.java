class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        int l1 = a.length;
        int l2 = b.length;
        // int p = 0, q = 0;

        int i = m - 1;          
        int j = n - 1;          
        int k = m + n - 1;      

        while (j >= 0) {
            if (i >= 0 && a[i] > b[j]) {
                a[k] = a[i];
                i--;
            } else {
                a[k] = b[j];
                j--;
            }
            k--;
        }
    }
}

// Time Complexity: O(m+n) bcoz while loop runs m + n times 
// Space complexity : O(1);