class Solution {
    public int numDecodings(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return help(0,s,dp);
    }
    int help(int i,String s,int dp[]){
        if(i==s.length())return 1;
        if(s.charAt(i)=='0')return 0;
        if(dp[i]!=-1)return dp[i];

        int ways=help(i+1,s,dp);
        if(i+1<s.length()){
            int num=(s.charAt(i)-'0')*10+s.charAt(i+1)-'0';
            if(num>=10&&num<=26){
                ways+=help(i+2,s,dp);
            }
        }
        dp[i]=ways;
        return ways;
    }
}