class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()+1][p.length()+1];

        return help(s,p,0,0);
    }
    boolean help(String s,String p,int i,int j){
        if(j==p.length()){
            return i==s.length();
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
       boolean f = i < s.length() &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j+1<p.length()&&p.charAt(j+1)=='*'){
            return dp[i][j]=help(s,p,i,j+2)||f&&help(s,p,i+1,j);
        }
        return  dp[i][j]=f&&help(s,p,i+1,j+1);
    }
}