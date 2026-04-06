class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) sum += s;

        int target = sum / 2;

        Integer dp[][] = new Integer[stones.length][target + 1];

        int best = solve(0, 0, stones, target, dp);

        return sum - 2 * best;
    }

    int solve(int i, int currSum, int[] stones, int target, Integer dp[][]) {

        // base case
        if (i == stones.length) {
            return currSum;
        }

        if (dp[i][currSum] != null) return dp[i][currSum];

        // not take
        int notTake = solve(i + 1, currSum, stones, target, dp);

        // take (only if valid)
        int take = currSum;
        if (currSum + stones[i] <= target) {
            take = solve(i + 1, currSum + stones[i], stones, target, dp);
        }

        return dp[i][currSum] = Math.max(take, notTake);
    }
}