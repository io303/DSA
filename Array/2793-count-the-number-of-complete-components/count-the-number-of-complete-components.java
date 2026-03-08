class Solution {
   static int nodes,edge;
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int res=0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                    nodes=0;
                    edge=0;
                    dfs(i,n,adj,visited);
                    edge=edge/2;
                    if(edge==(nodes*(nodes-1))/2){
                        res++;
                    }
            }
            
        }
        return res;
    }
    void dfs(int i,int n,ArrayList<ArrayList<Integer>> adj,boolean visited[]){
        visited[i]=true;
        nodes++;
        for(int neigh:adj.get(i)){
            edge++;
            if(!visited[neigh]){
                dfs(neigh,n,adj,visited);
            }
        }
    }
}