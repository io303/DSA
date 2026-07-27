import java.util.*;

class Solution {

    int[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {

        dp = new int[arr.length];

        Arrays.fill(dp, -1);

        return solve(0, arr, k);
    }

    int solve(int i, int[] arr, int k) {

        if (i == arr.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int max = 0;
        int ans = 0;

        for (int j = i; j < Math.min(arr.length, i + k); j++) {

            max = Math.max(max, arr[j]);

            int len = j - i + 1;

            int sum = len * max + solve(j + 1, arr, k);

            ans = Math.max(ans, sum);
        }

        return dp[i] = ans;
    }
}