import java.util.*;
public class Findpath {
    public static void main(String[] args) {
        int graph [][]={
            {0,1},{1,2},{2,0}
        };
        int source=0;
        int destination=2;
        int n=3;
      boolean x=  validPath(n,graph,source,destination);
      System.out.println(x);
    }

    private static boolean validPath(int n, int[][] graph, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:graph){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
     boolean visited[]=new boolean[n];
     return dfs(source,destination,adj,visited);

    }

    private static boolean dfs(int source, int destination, List<List<Integer>> adj, boolean[] visited) {
        if(destination==source){
            return true;
        }
        visited[source]=true;

        for( int neigh:adj.get(source)){
            if(!visited[neigh]){
                if(dfs(neigh,destination,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
