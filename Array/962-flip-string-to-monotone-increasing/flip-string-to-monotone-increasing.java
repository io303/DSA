class Solution {

    public int minFlipsMonoIncr(String s) {

        int n = s.length();

        // dp[i][p]
        // i = current index
        // p = previous output character
        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return help(0, s, dp, 0);
    }

    private int help(int i, String s, int[][] dp, int p) {

        // All characters processed
        if (i == s.length()) {
            return 0;
        }

        // Already calculated
        if (dp[i][p] != -1) {
            return dp[i][p];
        }

        int curr = s.charAt(i) - '0';

        int ans;

        // We can make current output 0
        if (p == 0) {

            // Option 1: Keep current as 0
            int keep0 = (curr == 0 ? 0 : 1)
                    + help(i + 1, s, dp, 0);

            // Option 2: Make current output 1
            int make1 = (curr == 1 ? 0 : 1)
                    + help(i + 1, s, dp, 1);

            ans = Math.min(keep0, make1);

        } else {

            // Previous output is already 1.
            // We cannot make current output 0.

            // So current output MUST be 1.
            int make1 = (curr == 1 ? 0 : 1)
                    + help(i + 1, s, dp, 1);

            ans = make1;
        }

        return dp[i][p] = ans;
    }
}