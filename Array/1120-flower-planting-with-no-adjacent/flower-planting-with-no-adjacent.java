class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n + 1];

        // Visit every component
        for (int i = 1; i <= n; i++) {

            if (color[i] == 0) {

                color[i] = 1;

                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while (!q.isEmpty()) {

                    int node = q.poll();

                    boolean[] used = new boolean[5];

                    // Mark colors used by neighbors
                    for (int neigh : adj.get(node)) {
                        if (color[neigh] != 0) {
                            used[color[neigh]] = true;
                        }
                    }

                    // Find available flower
                    for (int c = 1; c <= 4; c++) {

                        if (!used[c]) {
                            color[node] = c;
                            break;
                        }
                    }

                    // Add uncolored neighbors
                    for (int neigh : adj.get(node)) {

                        if (color[neigh] == 0) {
                            q.add(neigh);
                        }
                    }
                }
            }
        }

        // Remove index 0
        int[] ans = new int[n];

        for (int i = 1; i <= n; i++) {
            ans[i - 1] = color[i];
        }

        return ans;
    }
}