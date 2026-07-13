class Solution {
    public int numTrees(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return help(n,dp);
    }
    int help(int n,int dp[]){
        if(n<=1)return 1;
        if(dp[n]!=-1)return dp[n];
        int ans=0;
        for(int root=1;root<=n;root++){
            int l=root-1;
            int r=n-root;
            ans+=help(l,dp)*help(r,dp);
        }
        dp[n]=ans;
        return ans;
    }
}