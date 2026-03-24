class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
   

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int s1=sum/2;
         Boolean dp[][]=new Boolean[n][s1+1];
        return help(n-1,s1,nums,dp);
    }
    boolean  help(int i,int target,int nums[],Boolean dp[][]){
        if(target==0) return true;
        if(i<0) return false;
        if(dp[i][target] != null) return dp[i][target];
        boolean nottake = help(i-1,target,nums,dp);
        boolean take=false;
        if(target>=nums[i]){
            take=help(i-1,target-nums[i],nums,dp);
        }
        return dp[i][target]=take|| nottake;
    }
}