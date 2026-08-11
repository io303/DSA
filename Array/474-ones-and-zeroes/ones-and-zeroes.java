class Solution {
    Integer dp[][][];
     int c1=0,c2=0;
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new Integer[strs.length+1][m+1][n+1];
            return help(strs.length-1,m,n,strs);
    }
    int help(int  i,int m,int n,String s[]){
        if(i==0){
            if(valid(s[0],m,n)){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][m][n]!=null)return dp[i][m][n];
        int skip=help(i-1,m,n,s);
        int pick=0;
        if(valid(s[i],m,n)){
            pick=1+help(i-1,m-c1,n-c2,s);
        }
        return dp[i][m][n]=Math.max(skip,pick);
    }
    boolean valid(String s,int  m,int n){
        int co=0,cz=0;
        for(char ch:s.toCharArray()){
            if(ch=='0'){
                cz++;
            }else{
                co++;
            }
        }
        c1=cz;
        c2=co;

        return cz<=m&&co<=n;
    }
}