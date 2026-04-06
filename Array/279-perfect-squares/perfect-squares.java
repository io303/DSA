class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return help(n,dp);
    }
    int help(int n,int dp[]){
        if(n==0)return 0;
        if(dp[n]!= -1){
            return dp[n];
        }
        int mini=Integer.MAX_VALUE;
        for(int j=1;j*j<=n;j++){
            int res=1+help(n-j*j,dp);
            mini=Math.min(mini,res);
        }
        return dp[n]=mini;
    }
}