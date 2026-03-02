class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        
        int INF = 1000000000;
        int dist[][] = new int[n][n];

        // Initialize
        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Fill edges (FIXED LOOP)
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != INF && dist[k][j] != INF &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int reReachable = Integer.MAX_VALUE;
        int city = -1;

        // Count reachable
        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= threshold) {
                    count++;
                }
            }

            if (count <= reReachable) {   // tie → larger index
                reReachable = count;
                city = i;
            }
        }

        return city;
    }
}