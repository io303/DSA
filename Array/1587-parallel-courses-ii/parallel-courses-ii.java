import java.util.*;

class Solution {

    int n;
    int k;
    int[] pre;
    int[] dp;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {

        this.n = n;
        this.k = k;

        pre = new int[n];

        // Build prerequisite mask
        for (int[] relation : relations) {

            int u = relation[0] - 1;
            int v = relation[1] - 1;

            pre[v] |= (1 << u);
        }

        int total = 1 << n;

        dp = new int[total];

        Arrays.fill(dp, -1);

        return dfs(0);
    }

    private int dfs(int mask) {

        // All courses completed
        if (mask == (1 << n) - 1) {
            return 0;
        }

        if (dp[mask] != -1) {
            return dp[mask];
        }

        // Find currently available courses
        int available = 0;

        for (int i = 0; i < n; i++) {

            // Course not completed
            if ((mask & (1 << i)) == 0) {

                // All prerequisites completed
                if ((pre[i] & mask) == pre[i]) {

                    available |= (1 << i);
                }
            }
        }

        int count = Integer.bitCount(available);

        int ans = Integer.MAX_VALUE;

        // If we can take all available courses
        if (count <= k) {

            ans = 1 + dfs(mask | available);

        } else {

            // Choose exactly k courses
            int subset = available;

            while (subset > 0) {

                // Only consider subsets having exactly k courses
                if (Integer.bitCount(subset) == k) {

                    ans = Math.min(
                        ans,
                        1 + dfs(mask | subset)
                    );
                }

                // Generate next subset
                subset = (subset - 1) & available;
            }
        }

        dp[mask] = ans;

        return ans;
    }
}