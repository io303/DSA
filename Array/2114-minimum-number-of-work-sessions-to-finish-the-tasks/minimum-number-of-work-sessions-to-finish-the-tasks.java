class Solution {

    int n;
    int[] tasks;
    int sessionTime;

    int[][] dp;

    public int minSessions(int[] tasks, int sessionTime) {

        this.tasks = tasks;
        this.sessionTime = sessionTime;
        this.n = tasks.length;

        dp = new int[1 << n][sessionTime + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start with one empty session
        return solve(0, sessionTime);
    }

    int solve(int mask, int remaining) {

        // All tasks completed
        if (mask == (1 << n) - 1) {
            return 1;
        }

        if (dp[mask][remaining] != -1) {
            return dp[mask][remaining];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            // task already completed
            if ((mask & (1 << i)) != 0) {
                continue;
            }

            // Task fits in current session
            if (tasks[i] <= remaining) {

                int newMask = mask | (1 << i);

                ans = Math.min(
                    ans,
                    solve(newMask, remaining - tasks[i])
                );

            } else {

                // Start a new session
                int newMask = mask | (1 << i);

                ans = Math.min(
                    ans,
                    1 + solve(newMask, sessionTime - tasks[i])
                );
            }
        }

        return dp[mask][remaining] = ans;
    }
}