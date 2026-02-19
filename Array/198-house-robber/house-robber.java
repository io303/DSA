class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return help(n-1,nums,dp);
    }
    int help(int i,int arr[],int dp[]){
        if(i<0)  return 0;
        if(i==0) return arr[0];

        if(dp[i]!=-1) return dp[i];
        int pick=arr[i]+help(i-2,arr,dp);
        int np=help(i-1,arr,dp);
        return dp[i]=Math.max(pick,np);
    }
}