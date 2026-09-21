import java.util.*;

class Solution {

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Build graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        // dp[node][color]
        int[][] dp = new int[n][26];

        // Every node already has its own color once
        for (int i = 0; i < n; i++) {
            int color = colors.charAt(i) - 'a';
            dp[i][color] = 1;
        }

        Queue<Integer> q = new LinkedList<>();

        // Nodes having no prerequisites
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int processed = 0;
        int answer = 0;

        while (!q.isEmpty()) {

            int u = q.poll();
            processed++;

            // Check maximum color value at u
            for (int c = 0; c < 26; c++) {
                answer = Math.max(answer, dp[u][c]);
            }

            for (int v : graph.get(u)) {

                // Transfer DP from u -> v
                for (int c = 0; c < 26; c++) {

                    int extra = 0;

                    if (colors.charAt(v) - 'a' == c) {
                        extra = 1;
                    }

                    dp[v][c] = Math.max(
                        dp[v][c],
                        dp[u][c] + extra
                    );
                }

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        // If not all nodes processed => cycle
        if (processed != n) {
            return -1;
        }

        return answer;
    }
}