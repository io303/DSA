class Solution {

    int MOD = 1_000_000_007;

    int m, n;

    int[][] dp;

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int countPaths(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];

        long ans = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                ans += dfs(i, j, grid);

                ans %= MOD;
            }
        }

        return (int) ans;
    }

    int dfs(int r, int c, int[][] grid) {

        // Already calculated
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        // Cell itself
        long ways = 1;

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            // Out of bounds
            if (nr < 0 || nr >= m ||
                nc < 0 || nc >= n) {
                continue;
            }

            // Must move to a larger value
            if (grid[nr][nc] > grid[r][c]) {

                ways += dfs(nr, nc, grid);

                ways %= MOD;
            }
        }

        dp[r][c] = (int) ways;

        return dp[r][c];
    }
}