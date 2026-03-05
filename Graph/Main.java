import java.util.*;

public class Main {

    static void dfs(int node, int[][] matrix, boolean[] visited,
                    ArrayList<Integer> component, int V) {

        visited[node] = true;
        component.add(node);

        for (int i = 0; i < V; i++) {
            if (matrix[node][i] == 1 && !visited[i]) {
                dfs(i, matrix, visited, component, V);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();   // number of vertices
        int E = sc.nextInt();   // number of edges

        int[][] matrix = new int[V][V];

        // Take edges input
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            matrix[u][v] = 1;
            matrix[v][u] = 1;   // undirected graph
        }

        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, matrix, visited, component, V);
                Collections.sort(component);
                result.add(component);
            }
        }

        // Sort outer list (optional – like GFG driver does)
        // result.sort((a, b) -> a.get(0) - b.get(0));


        System.out.println(result);

        sc.close();
    }
}
