import java.util.LinkedList;
import java.util.Queue;

public class Graph4 {
    
 private int[][] adj;   // adjacency matrix
    private int V;         // number of vertices

    // Constructor
    public Graph4(int vertices) {
        this.V = vertices;
        adj = new int[V][V];   // initialize matrix with 0
    }

    // Add edge (undirected graph)
    public void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    // Print adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    // BFS traversal
    public void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        System.out.print("BFS: ");

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            // check all neighbors using matrix
            for (int i = 0; i < V; i++) {
                if (adj[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println();
    }

    // DFS traversal
    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        // check all neighbors using matrix
        for (int i = 0; i < V; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfsHelper(i, visited);
            }
        }
    }

    // Main to test
    public static void main(String[] args) {
        Graph4 g = new Graph4(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        g.printGraph();
        g.BFS(0);
        g.DFS(0);
    }
}
