
class Solution {
    double[][] dp;
    int[] prefix;
    int n;

    public double largestSumOfAverages(int[] nums, int k) {
        n = nums.length;

        dp = new double[n][k + 1];
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (double[] a : dp) {
            Arrays.fill(a, -1);
        }

        return help(0, k);
    }

    double help(int i, int k) {

        if (i == n) return 0;

        if (k == 0) return Double.NEGATIVE_INFINITY;

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        double ans = 0;

        for (int j = i; j < n; j++) {

            double avg = (double)(prefix[j + 1] - prefix[i])
                         / (j - i + 1);

            double remaining = help(j + 1, k - 1);

            ans = Math.max(ans, avg + remaining);
        }

        return dp[i][k] = ans;
    }
}
