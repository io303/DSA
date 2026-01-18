import java.util.*;

public class CycleDetection {

    // Function to check cycle
    static boolean isCycle(int V, int[][] graph) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // BFS function
    static boolean bfs(int src, int[][] graph, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});
        visited[src] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int neigh = 0; neigh < graph.length; neigh++) {
                if (graph[node][neigh] == 1) {

                    if (!visited[neigh]) {
                        visited[neigh] = true;
                        q.add(new int[]{neigh, node});
                    }
                    else if (neigh != parent) {
                        return true;   // cycle detected
                    }
                }
            }
        }
        return false;
    }

    // Main function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean result = isCycle(V, graph);

        System.out.println("Cycle present: " + result);
    }
}
