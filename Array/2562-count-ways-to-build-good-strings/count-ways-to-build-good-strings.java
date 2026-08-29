class Solution {

    static final int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {

        int[] dp = new int[high + 1];

        Arrays.fill(dp, -1);

        return help(0, low, high, zero, one, dp);
    }

    int help(int len, int low, int high, int zero, int one, int[] dp) {

        // Length exceeded
        if (len > high) {
            return 0;
        }

        if (dp[len] != -1) {
            return dp[len];
        }

        long ans = 0;

        // Current string is valid
        if (len >= low) {
            ans = 1;
        }

        // Add zero zeros
        ans += help(len + zero, low, high, zero, one, dp);

        // Add one ones
        ans += help(len + one, low, high, zero, one, dp);

        return dp[len] = (int)(ans % MOD);
    }
}