class Solution {
    public void rotate(int[][] a) {
        int n = a.length;

        for (int j = 0; j < n; j++) {
            for (int i = j+1; i < n; i++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;

            while (l < r) {
                int temp = a[i][l];
                a[i][l] = a[i][r];
                a[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}

// Time Complexity: O(N/2 * N/2) + O( N * N/2 )
//                    1st * 2nd      for  while
//                    (for loop)     loop loop

// Space Complexity: O(1) (because no extra space is used)