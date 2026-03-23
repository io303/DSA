

class Solution {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[][] dp = new long[n][2];

        
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return help(0, 1, dp, nums, n);
    }

    long help(int i, int isEven, long[][] dp, int[] nums, int n) {
        if (i == n) return 0;

        if (dp[i][isEven] != -1) return dp[i][isEven];

        long s = help(i + 1, isEven, dp, nums, n);
        long t;

        if (isEven == 1) {
            t = nums[i] + help(i + 1, 0, dp, nums, n);
        } else {
            t = -nums[i] + help(i + 1, 1, dp, nums, n);
        }

        return dp[i][isEven] = Math.max(t, s);
    }
}