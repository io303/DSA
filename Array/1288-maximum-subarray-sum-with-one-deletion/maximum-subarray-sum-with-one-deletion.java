class Solution {

    Integer[][] dp;

    public int maximumSum(int[] arr) {

        int n = arr.length;
        dp = new Integer[n][2];

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i, 0, arr));
        }

        return ans;
    }

    int solve(int i, int deleted, int[] arr) {

        if (i == arr.length) {
            return Integer.MIN_VALUE / 2;
        }

        if (dp[i][deleted] != null) {
            return dp[i][deleted];
        }

        // PICK current element
        int pick = arr[i];

        if (i + 1 < arr.length) {
            pick = Math.max(
                pick,
                arr[i] + solve(i + 1, deleted, arr)
            );
        }

        // DELETE current element
        int skip = Integer.MIN_VALUE / 2;

        if (deleted == 0 && i + 1 < arr.length) {
            skip = solve(i + 1, 1, arr);
        }

        return dp[i][deleted] = Math.max(pick, skip);
    }
}