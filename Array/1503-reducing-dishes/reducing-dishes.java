class Solution {

    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);

        int n = satisfaction.length;

        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return help(0, 1, satisfaction, dp);
    }

    private int help(int i, int time, int[] arr, int[][] dp) {

        // No dishes left
        if (i == arr.length) {
            return 0;
        }

        if (dp[i][time] != -1) {
            return dp[i][time];
        }

        // Skip current dish
        int skip = help(i + 1, time, arr, dp);

        // Pick current dish
        int pick = arr[i] * time
                + help(i + 1, time + 1, arr, dp);

        return dp[i][time] = Math.max(pick, skip);
    }
}