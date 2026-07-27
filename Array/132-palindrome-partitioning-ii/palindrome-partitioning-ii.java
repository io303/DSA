class Solution {
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return help(0,s,dp)-1;
    }
    int help(int i,String s,int dp[]){
        if(i==s.length()) return 0;
        if(dp[i]!=-1)return dp[i];

        int ans=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalin(i,j,s)){
                int c=1+help(j+1,s,dp);
                ans=Math.min(c,ans);
            }
            
        }
        return dp[i]=ans;
    }
    boolean isPalin(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}