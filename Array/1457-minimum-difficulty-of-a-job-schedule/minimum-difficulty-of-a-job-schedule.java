class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;

            if(d>n)return -1;
        int dp[][]=new int[n+1][d+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return help(0,d,dp,jobDifficulty);
    }
    int help(int idx,int d,int dp[][],int arr[]){
        if(dp[idx][d]!=-1)return dp[idx][d];
         int n=arr.length;
        // if(idx==arr.length)return 0;
        if(d==1){
            int maxd=arr[idx];
            for(int i=idx;i<n;i++){
                maxd=Math.max(maxd,arr[i]);
            }
            return maxd;
        }

        int ans=Integer.MAX_VALUE;
        int maxi=0;

       
        for(int i=idx;i<=n-d;i++){
            maxi=Math.max(maxi,arr[i]);

            int res=maxi+help(i+1,d-1,dp,arr);
            ans=Math.min(res,ans);
        }
        return dp[idx][d]=ans;
    }
}