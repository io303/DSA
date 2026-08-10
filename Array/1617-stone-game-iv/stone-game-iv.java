class Solution {

    int[] dp;

    public boolean winnerSquareGame(int n) {

        dp = new int[n + 1];

        // -1 = not calculated
        //  0 = lose
        //  1 = win
        Arrays.fill(dp, -1);

        return solve(n);
    }

    private boolean solve(int n) {

        // No stones -> current player loses
        if (n == 0) {
            return false;
        }

        // Already calculated
        if (dp[n] != -1) {
            return dp[n] == 1;
        }

        // Try every perfect square
        for (int x = 1; x * x <= n; x++) {

            int square = x * x;

            // If opponent loses after our move,
            // current player wins.
            if (!solve(n - square)) {

                dp[n] = 1;
                return true;
            }
        }

        // No winning move
        dp[n] = 0;

        return false;
    }
}