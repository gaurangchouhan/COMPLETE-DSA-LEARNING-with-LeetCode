class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;      
        int n = mat[0].length;   

        int low = 0;
        int high = n - 1;        

        while (low <= high) {
            int mid = (low + high) / 2;

            int maxRow = maxEle(mat, m, n, mid); 

            int left = (mid - 1 >= 0) ? mat[maxRow][mid - 1] : Integer.MIN_VALUE;
            int right = (mid + 1 < n) ? mat[maxRow][mid + 1] : Integer.MIN_VALUE;

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            } else if (mat[maxRow][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public int maxEle(int[][] mat, int rows, int cols, int col) {
        int max = Integer.MIN_VALUE;
        int idx = -1;

        for (int i = 0; i < rows; i++) { 
            if (mat[i][col] > max) {
                max = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }
}

// Time complexity: O(n log(m))
// Space complexity: O(1)