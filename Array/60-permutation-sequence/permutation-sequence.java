class Solution {
    int c=0;
    String ans="";
    public String getPermutation(int n, int k) {
        boolean seen[]=new boolean[n+1];

        help(n,k,seen,"");
        return ans;
    }
    void help(int n,int k,boolean seen[],String curr){
        if(curr.length()==n){
            c++;
            if(c==k){
                ans=curr;
            }
            return;
        }

        for(int i=1;i<=n;i++){
            if(!seen[i]){
                seen[i]=true;
                help(n,k,seen,curr+i);
                seen[i]=false;

                if(!ans.equals("")){
                    return;
                }
            }
        }
    }
}