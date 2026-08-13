class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=0;i<=n;i++){
            ls.add(new ArrayList<>());
        }
        for(int a[]:dislikes){
           ls.get(a[0]).add(a[1]);
          ls.get(a[1]).add(a[0]);
        }
        int color[]=new int[n+1];
        Arrays.fill(color,-1);

        for(int  i=0;i<=n;i++){
            if(color[i]==-1){
                if(!help(i,ls,color)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean help(int node,List<List<Integer>> adj,int color[]){
        Queue<Integer> q=new  LinkedList<>();

        q.add(node);
        color[node]=0;

        while(!q.isEmpty()){
            int n=q.poll();
            for(int neigh:adj.get(n)){
                if(color[neigh]==-1){
                    color[neigh]=1-color[n];
                    q.add(neigh);
                }
                else if(color[neigh]==color[n]){
                    return false;
                }
            }
        }
        return true;
    }
}