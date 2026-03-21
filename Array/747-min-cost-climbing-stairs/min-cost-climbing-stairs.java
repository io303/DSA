class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
         int dp1[]=new int[n];
        Arrays.fill(dp1,-1);
        int j= help(0,dp,cost);
        int k=help(1,dp1,cost);
        return Math.min(j,k);

    }
    int help(int i,int dp[],int cost[]){
         int n=cost.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int one=cost[i]+help(i+1,dp,cost);
        
          int   two=cost[i]+help(i+2,dp,cost);
        
        return dp[i]=Math.min(one,two);
    }
}