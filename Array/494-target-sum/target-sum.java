import java.util.*;

class Solution {
    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalsum = 0;

        for (int num : nums) totalsum += num;

        // ✅ Correct feasibility check
        if ((totalsum - target) < 0 || (totalsum - target) % 2 != 0)
            return 0;

        int sum = (totalsum - target) / 2;

        dp = new int[n][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return help(n - 1, sum, nums);
    }

    int help(int i, int t, int[] arr) {
        if (t < 0) return 0;  // ✅ Important

        if (i == 0) {
            if (t == 0 && arr[0] == 0) return 2; // +0 and -0
            if (t == 0 || arr[0] == t) return 1;
            return 0;
        }

        if (dp[i][t] != -1) return dp[i][t];

        int nottake = help(i - 1, t, arr);
        int take = 0;

        if (arr[i] <= t)
            take = help(i - 1, t - arr[i], arr);

        return dp[i][t] = take + nottake;
    }
}

