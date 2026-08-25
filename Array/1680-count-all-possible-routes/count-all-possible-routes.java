class Solution {
    int mod=1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n=locations.length;

        int dp[][]=new int[n+1][fuel+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return help(start,fuel,finish,locations,dp);
    }
    int help(int c,int f,int l,int arr[],int dp[][]){
        if(dp[c][f]!=-1)return dp[c][f];
        long ways=0;
        if(c==l){
            ways=1;
        }
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(i==c)continue;

            int cost=Math.abs(arr[c]-arr[i]);
            if(cost<=f){
                ways+=help(i,f-cost,l,arr,dp);
                ways%=mod;
            }
        }
            return dp[c][f]=(int)ways;
    }
}