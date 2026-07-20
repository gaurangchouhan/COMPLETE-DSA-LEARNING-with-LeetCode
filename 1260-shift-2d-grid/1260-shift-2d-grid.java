class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        k %= size;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }

        for (int i = 0; i < size; i++) {
            int newIndex = (i + k) % size;
            int newRow = newIndex / n;
            int newCol = newIndex % n;

            int oldRow = i / n;
            int oldCol = i % n;

            ans.get(newRow).set(newCol, grid[oldRow][oldCol]);
        }

        return ans;
    }
}