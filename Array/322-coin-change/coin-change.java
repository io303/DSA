class Solution {
    int imf=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=help(amount,dp,coins);
        if(ans==imf)return -1;
        return ans;
    }
    int help(int amount,int dp[],int coin[]){
        if(amount==0)return 0;
        if(dp[amount]!=-1)return dp[amount];
        int ans=imf;
        for(int a:coin){
            if(amount>=a){
                int res=help(amount-a,dp,coin);

                if(res!=imf){
                    ans=Math.min(ans,1+res);
                }
            }
        }
        return dp[amount]=ans;
    }
}