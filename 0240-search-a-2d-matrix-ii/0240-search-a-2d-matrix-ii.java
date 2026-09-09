class Solution {
    public boolean searchMatrixBetter(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        boolean found = false;
            for(int i=0; i<n; i++){
                int low = 0;
                int high = m-1;

                while(low <= high){
                    int mid = (low + high)/2;
                    int col = mid % m;

                    if(mat[i][col] == target){
                        found = true;
                        return true;
                    }
                    else if(mat[i][col] < target){
                        low = mid+1;
                    }
                    else{
                        high = mid - 1;
                    }
                }
            }
        
        return false;
    }

    // Time complexity: n * logn
    // Space complexity: O(1)

    public boolean searchMatrix(int[][] mat, int target){
        int n = mat.length;
        int m = mat[0].length;
        int row = 0;
        int col = m-1;

        while(row<n && col >= 0){
            if(mat[row][col] == target) return true;
            else if(mat[row][col] < target) row++;
            else col--;
        }
        return false;
    }

    // Time complexity: O(n + m)
    // Space complexity: O(1)
}