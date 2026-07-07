class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        Integer dp[][]=new Integer[n][n];
        return help(nums,dp,0,n-1)>=0;
    }
    int help(int nums[],Integer dp[][],int i,int j){
        if(i==j){
            return nums[i];
        }
        int left=nums[i]-help(nums,dp,i+1,j);
        int right=nums[j]-help(nums,dp,i,j-1);
        return dp[i][j]=Math.max(left,right);
    }
}