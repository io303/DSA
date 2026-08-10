class Solution {

    int n;
    int[][] dp;

    private int solve(int[] stoneValue, int person, int i) {

        // No stones left
        if (i >= n) {
            return 0;
        }

        // Already calculated
        if (dp[person][i] != -1) {
            return dp[person][i];
        }

        // Alice -> maximize
        // Bob   -> minimize
        int result = (person == 1)
                   ? Integer.MIN_VALUE
                   : Integer.MAX_VALUE;

        int stones = 0;

        // Take 1, 2, or 3 stones
        for (int x = 1; x <= 3 && i + x <= n; x++) {

            stones += stoneValue[i + x - 1];

            if (person == 1) {

                // Alice's turn
                result = Math.max(
                    result,
                    stones + solve(
                        stoneValue,
                        0,          // Bob
                        i + x
                    )
                );

            } else {

                // Bob's turn
                result = Math.min(
                    result,
                    solve(
                        stoneValue,
                        1,          // Alice
                        i + x
                    )
                );
            }
        }

        return dp[person][i] = result;
    }

    public String stoneGameIII(int[] stoneValue) {

        n = stoneValue.length;

        dp = new int[2][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int aliceScore = solve(stoneValue, 1, 0);

        int total = 0;

        for (int x : stoneValue) {
            total += x;
        }

        int bobScore = total - aliceScore;

        if (aliceScore > bobScore) {
            return "Alice";
        } else if (aliceScore < bobScore) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}