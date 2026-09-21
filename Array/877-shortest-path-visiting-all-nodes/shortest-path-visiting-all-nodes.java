import java.util.*;

class Solution {

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;

        int fullMask = (1 << n) - 1;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited =
            new boolean[n][1 << n];

        // Start BFS from every node
        for (int i = 0; i < n; i++) {

            int mask = 1 << i;

            q.add(new int[]{i, mask});

            visited[i][mask] = true;
        }

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // One BFS level = one edge
            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int node = curr[0];
                int mask = curr[1];

                // All nodes visited
                if (mask == fullMask) {
                    return steps;
                }

                for (int nei : graph[node]) {

                    int newMask =
                        mask | (1 << nei);

                    if (!visited[nei][newMask]) {

                        visited[nei][newMask] = true;

                        q.add(
                            new int[]{nei, newMask}
                        );
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}