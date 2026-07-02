class Solution {

    int m, n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        m = grid.size();
        n = grid.get(0).size();

        // Lose health if starting cell is unsafe
        health -= grid.get(0).get(0);

        if (health <= 0)
            return false;

        int[][] bestHealth = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(bestHealth[i], -1);
        }

        return dfs(grid, 0, 0, health, bestHealth);
    }

    private boolean dfs(List<List<Integer>> grid,
                        int r,
                        int c,
                        int health,
                        int[][] bestHealth) {

        if (r == m - 1 && c == n - 1)
            return health >= 1;

        // Already reached this cell with equal or more health
        if (bestHealth[r][c] >= health)
            return false;

        bestHealth[r][c] = health;

        for (int k = 0; k < 4; k++) {

            int nr = r + dx[k];
            int nc = c + dy[k];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;

            int newHealth = health - grid.get(nr).get(nc);

            if (newHealth <= 0)
                continue;

            if (dfs(grid, nr, nc, newHealth, bestHealth))
                return true;
        }

        return false;
    }
}