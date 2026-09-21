class Solution {

    int m, n, target;
    int[][][] dp;
    int INF = 1000000000;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        this.m = m;
        this.n = n;
        this.target = target;

        // prevColor: 0 to n
        // groups: 0 to target
        dp = new int[m][n + 1][target + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = solve(0, 0, 0, houses, cost);

        return ans >= INF ? -1 : ans;
    }

    int solve(int i, int prevColor, int groups,
              int[] houses, int[][] cost) {

        // Too many neighborhoods
        if (groups > target) {
            return INF;
        }

        // All houses processed
        if (i == m) {
            if (groups == target) {
                return 0;
            }
            return INF;
        }

        // Already calculated
        if (dp[i][prevColor][groups] != -1) {
            return dp[i][prevColor][groups];
        }

        int ans = INF;

        // House already painted
        if (houses[i] != 0) {

            int color = houses[i];

            int newGroups = groups;

            if (color != prevColor) {
                newGroups++;
            }

            ans = solve(
                i + 1,
                color,
                newGroups,
                houses,
                cost
            );
        }

        // House is unpainted
        else {

            for (int color = 1; color <= n; color++) {

                int newGroups = groups;

                if (color != prevColor) {
                    newGroups++;
                }

                int paintCost = cost[i][color - 1];

                int next = solve(
                    i + 1,
                    color,
                    newGroups,
                    houses,
                    cost
                );

                if (next != INF) {
                    ans = Math.min(
                        ans,
                        paintCost + next
                    );
                }
            }
        }

        return dp[i][prevColor][groups] = ans;
    }
}