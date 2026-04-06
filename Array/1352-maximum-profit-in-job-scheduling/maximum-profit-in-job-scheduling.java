class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int jobs[][]=new int[n][3];
        for(int i=0;i<n;i++){
            jobs[i]=new int[]{startTime[i],endTime[i],profit[i]};
        }
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        return help(0,new Integer[n],jobs);
    }
    int help(int curr,Integer dp[],int jobs[][]){
        if(curr==jobs.length) return 0;
        if(dp[curr]!=null)return dp[curr];

        int s=help(curr+1,dp,jobs);
        int p=jobs[curr][2]+help(find(curr,jobs),dp,jobs);
        return dp[curr]=Math.max(s,p);
    }
    int find(int curr,int jobs[][]){
        for(int next=curr+1;next<jobs.length;next++){
            if(jobs[next][0]>=jobs[curr][1]){
                return next;
            }
        }
        return jobs.length;
    }
}