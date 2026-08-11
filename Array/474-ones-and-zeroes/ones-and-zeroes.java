class Solution {
    Integer[][][] dp;

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        dp = new Integer[len][m + 1][n + 1];

        return help(strs, len - 1, m, n);
    }

    int help(String[] strs, int i, int m, int n) {

        // Base case
        if (i < 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][m][n] != null) {
            return dp[i][m][n];
        }

        // Count 0s and 1s
        int zeros = 0;
        int ones = 0;

        for (char ch : strs[i].toCharArray()) {
            if (ch == '0') {
                zeros++;
            } else {
                ones++;
            }
        }

        // Option 1: Don't take current string
        int skip = help(strs, i - 1, m, n);

        // Option 2: Take current string
        int pick = 0;

        if (zeros <= m && ones <= n) {
            pick = 1 + help(strs, i - 1, m - zeros, n - ones);
        }

        return dp[i][m][n] = Math.max(skip, pick);
    }
}