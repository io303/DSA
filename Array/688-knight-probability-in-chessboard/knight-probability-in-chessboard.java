class Solution {

    double[][][] dp;

    int[][] dir = {
        {-2, -1},
        {-2,  1},
        {-1, -2},
        {-1,  2},
        { 1, -2},
        { 1,  2},
        { 2, -1},
        { 2,  1}
    };

    public double knightProbability(int n, int k, int row, int column) {

        dp = new double[n][n][k + 1];

        // -1 means not calculated
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1.0);
            }
        }

        return solve(n, row, column, k);
    }

    double solve(int n, int row, int col, int moves) {

        // No moves remaining
        if (moves == 0) {
            return 1.0;
        }

        // Already calculated
        if (dp[row][col][moves] != -1.0) {
            return dp[row][col][moves];
        }

        double ans = 0.0;

        for (int[] d : dir) {

            int nr = row + d[0];
            int nc = col + d[1];

            // Valid position
            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < n) {

                ans += solve(n, nr, nc, moves - 1) / 8.0;
            }
        }

        return dp[row][col][moves] = ans;
    }
}