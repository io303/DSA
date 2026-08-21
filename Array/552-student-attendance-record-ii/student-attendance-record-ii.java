class Solution {

    static final int MOD = 1_000_000_007;

    int n;
    Integer[][][] dp;

    public int checkRecord(int n) {

        this.n = n;

        dp = new Integer[n + 1][2][3];

        return solve(0, 0, 0);
    }

    private int solve(int i, int absent, int late) {

        // Complete valid record
        if (i == n) {
            return 1;
        }

        // Already calculated
        if (dp[i][absent][late] != null) {
            return dp[i][absent][late];
        }

        long ans = 0;

        // 1. Present
        ans += solve(i + 1, absent, 0);

        // 2. Absent
        if (absent < 1) {
            ans += solve(i + 1, absent + 1, 0);
        }

        // 3. Late
        if (late < 2) {
            ans += solve(i + 1, absent, late + 1);
        }

        return dp[i][absent][late] =
                (int) (ans % MOD);
    }
}