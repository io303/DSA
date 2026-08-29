class Solution {
    public long mostPoints(int[][] questions) {
      int n=questions.length;
      long dp[]=new long[n+1];

        Arrays.fill(dp,-1);
       
      return help(0,dp,questions);
    }
    long help(int i,long dp[],int arr[][]){
        if(i>=arr.length)return 0;
        if(dp[i]!=-1)return dp[i];

        long sp=help(i+1,dp,arr);
        long p=arr[i][0]+help(i+arr[i][1]+1,dp,arr);
    return dp[i]=Math.max(sp,p);
    }
}