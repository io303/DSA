class Solution {

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : connections) {
            union(edge[0], edge[1], parent, rank);
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (findParent(i, parent) == i) {
                components++;
            }
        }

        return components - 1;
    }

    void union(int a, int b, int[] parent, int[] rank) {

        int pa = findParent(a, parent);
        int pb = findParent(b, parent);

        if (pa == pb) {
            return;
        }

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        }
        else if (rank[pb] < rank[pa]) {
            parent[pb] = pa;
        }
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    int findParent(int node, int[] parent) {

        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findParent(parent[node], parent);
    }
}