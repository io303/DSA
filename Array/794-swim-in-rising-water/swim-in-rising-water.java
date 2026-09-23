import java.util.*;

class Solution {

    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;

        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;

        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        int total = n * n;

        parent = new int[total];
        rank = new int[total];

        for (int i = 0; i < total; i++) {
            parent[i] = i;
        }

        // {height, row, col}
        int[][] cells = new int[total][3];

        int k = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                cells[k][0] = grid[r][c];
                cells[k][1] = r;
                cells[k][2] = c;

                k++;
            }
        }

        // Sort according to height
        Arrays.sort(cells, (a, b) -> a[0] - b[0]);

        boolean[][] active = new boolean[n][n];

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] cell : cells) {

            int height = cell[0];
            int r = cell[1];
            int c = cell[2];

            active[r][c] = true;

            int id = r * n + c;

            // Connect with already active neighbors
            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    active[nr][nc]) {

                    int nid = nr * n + nc;

                    union(id, nid);
                }
            }

            // Start and destination connected?
            if (find(0) == find(total - 1)) {
                return height;
            }
        }

        return -1;
    }
}