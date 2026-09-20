import java.util.*;

class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions,
                               int[][] colConditions) {

        // Find valid row ordering
        List<Integer> rowOrder = topoSort(k, rowConditions);

        // Find valid column ordering
        List<Integer> colOrder = topoSort(k, colConditions);

        // Cycle exists in either graph
        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][0];
        }

        // number -> row
        int[] rowPos = new int[k + 1];

        // number -> column
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }

        // Create matrix
        int[][] ans = new int[k][k];

        // Put every number at its row and column
        for (int num = 1; num <= k; num++) {
            ans[rowPos[num]][colPos[num]] = num;
        }

        return ans;
    }


    private List<Integer> topoSort(int k, int[][] conditions) {

        // Graph
        List<Integer>[] graph = new ArrayList[k + 1];

        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        // Indegree
        int[] indegree = new int[k + 1];

        // Build graph
        for (int[] edge : conditions) {

            int from = edge[0];
            int to = edge[1];

            graph[from].add(to);
            indegree[to]++;
        }

        // Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();

            order.add(node);

            for (int neighbour : graph[node]) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return order;
    }
}