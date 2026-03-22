import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums) max = Math.max(max, num);

        int[] points = new int[max + 1];
        for(int num : nums){
            points[num] += num;
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);

        return help(0, points, dp);
    }

    int help(int i, int[] points, int[] dp){
        if(i >= points.length) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = points[i] + help(i + 2, points, dp);
        int skip = help(i + 1, points, dp);

        return dp[i] = Math.max(pick, skip);
    }
}