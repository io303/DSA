class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Indegree
        int[] indegree = new int[n];

        // Build graph
        for (int[] a : edges) {

            int u = a[0];
            int v = a[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        // Ancestors
        List<Set<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new HashSet<>());
        }

        // Topological sort
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                q.add(i);          // NOT indegree[i]
            }
        }

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int v : adj.get(u)) {

                // u is an ancestor of v
                ans.get(v).add(u);

                // All ancestors of u are also ancestors of v
                ans.get(v).addAll(ans.get(u));

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.add(v);      // NOT indegree[v]
                }
            }
        }

        // Convert Set -> List and sort
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            List<Integer> list =
                new ArrayList<>(ans.get(i));

            Collections.sort(list);

            result.add(list);
        }

        return result;
    }
}