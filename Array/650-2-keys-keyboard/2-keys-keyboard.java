class Solution {
    Integer[][] dp;

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }

        dp = new Integer[n + 1][n + 1];

        return help(1, 0, n);
    }

    int help(int i, int j, int n) {

        // We reached exactly n A's
        if (i == n) {
            return 0;
        }

        // We crossed n
        if (i > n) {
            return Integer.MAX_VALUE / 2;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Option 1: Copy All
        int copy = Integer.MAX_VALUE / 2;

        if (i != j) {
            copy = 1 + help(i, i, n);
        }

        // Option 2: Paste
        int paste = Integer.MAX_VALUE / 2;

        if (j > 0 && i + j <= n) {
            paste = 1 + help(i + j, j, n);
        }

        return dp[i][j] = Math.min(copy, paste);
    }
}