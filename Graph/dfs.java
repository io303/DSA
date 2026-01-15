import java.util.ArrayList;

public class dfs {
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

          adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);
        boolean visited[]=new boolean[v];
        dfs(0,adj,visited);
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i]=true;
        System.out.print(i+" ");
        for(int j:adj.get(i)){
            if(!visited[j]){
                dfs(j,adj,visited);
            }
        }
    }
}
