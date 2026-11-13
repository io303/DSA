class Solution {
    static final int MOD=1000000007;
    int dp[][][];

    public int dieSimulator(int n, int[] rollMax) {
        dp=new int[n][6][16];
        for(int a[][]:dp){
            for(int b[]:a){
                Arrays.fill(b,-1);
            }
        }
        return help(0,-1,0,n,rollMax);
    }
    int help(int pos,int last,int c,int n,int roll[]){
        if(pos==n)return 1;

        if(last!=-1&&dp[pos][last][c]!=-1)return dp[pos][last][c];
        long ans=0;

        for(int f=0;f<6;f++){
            if(f==last){
                if(c<roll[f]){
                    ans+=help(pos+1,f,c+1,n,roll);
                }
            }else{
                ans+=help(pos+1,f,1,n,roll);
            }
            ans%=MOD;
        }
        if(last!=-1){
            dp[pos][last][c]=(int)ans;
        }
        return (int)ans;
    }
}