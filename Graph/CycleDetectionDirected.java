import java.util.*;

public class CycleDetectionDirected {
    public static void main(String[] args) {
        int v=4;
        ArrayList<ArrayList<Integer>>  adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); 
       if (isCyclic(v, adj))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }





    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack))
                    return true;
            }
        }
        return false;
    }

    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       boolean[] visited, boolean[] recStack) {

        visited[node] = true;
        recStack[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, adj, visited, recStack))
                    return true;
            } 
            else if (recStack[nei]) {
                return true; // cycle found
            }
        }

        recStack[node] = false;
        return false;
    }
}