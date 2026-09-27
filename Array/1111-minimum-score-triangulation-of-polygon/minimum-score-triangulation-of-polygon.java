class Solution {

    int[][] dp;

    public int minScoreTriangulation(int[] values) {

        int n = values.length;

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, n - 1, values);
    }

    private int solve(int i, int j, int[] values) {

        if (j - i < 2) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {

            int cost =
                solve(i, k, values)
                + solve(k, j, values)
                + values[i] * values[k] * values[j];

            ans = Math.min(ans, cost);
        }

        return dp[i][j] = ans;
    }
}