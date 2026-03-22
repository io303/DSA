class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(stones[i],i);
        }
        Boolean dp[][]=new Boolean[n+1][n+1];
       return dfs(0,0,map,stones,dp);
    }
    boolean dfs(int i,int j,Map<Integer,Integer> map,int stones[],Boolean dp[][]){
        if(i==stones.length-1) return true;
        if(dp[i][j]!=null) return dp[i][j];
        for(int k=j-1;k<=j+1;k++){
            if(k>0){
                int nextpos=stones[i]+k;
                if(map.containsKey(nextpos)){
                    if(dfs(map.get(nextpos),k,map,stones,dp)){
                        return dp[i][j]=true;
                    }
                }
            }
        }
        return dp[i][j]= false;
    }
}