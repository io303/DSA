class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // Reverse graph
        List<List<Integer>> rev = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }

        // outdegree of original graph
        int[] outdegree = new int[n];

        for (int u = 0; u < n; u++) {

            outdegree[u] = graph[u].length;

            for (int v : graph[u]) {
                rev.get(v).add(u);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Terminal nodes
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        // BFS / Kahn's algorithm
        while (!q.isEmpty()) {

            int node = q.poll();

            safe[node] = true;

            // Nodes which point to 'node'
            for (int prev : rev.get(node)) {

                outdegree[prev]--;

                if (outdegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}