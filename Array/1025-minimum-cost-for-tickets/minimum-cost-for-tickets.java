class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length+1];
        Arrays.fill(dp,-1);
        return help(0,dp,days,costs);
    }
    int help(int i,int dp[],int d[],int c[]){
        if(i>=d.length)return  0;
        if(dp[i]!=-1)return dp[i];
        int j=i;
        while(j<d.length&&d[j]<d[i]+1){
            j++;
        }
        int one=c[0]+help(j,dp,d,c);
          j=i;
        while(j<d.length&&d[j]<d[i]+7){
            j++;
        }
        int week=c[1]+help(j,dp,d,c);
          j=i;
        while(j<d.length&&d[j]<d[i]+30){
            j++;
        }
        int month=c[2]+help(j,dp,d,c);
        dp[i]=Math.min(one,Math.min(week,month));
        return dp[i];
    }
    
}