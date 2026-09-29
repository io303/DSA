import java.util.*;

class Solution {

    int[] parent;
    int[] size;

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

        // Union by size
        if (size[pa] < size[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];
    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        parent = new int[n * n];
        size = new int[n * n];

        // Initialize DSU
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Step 1: Connect all existing 1's
        for (int r = 0; r < n; r++) {

            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 0)
                    continue;

                int id = r * n + c;

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1) {

                        int nid = nr * n + nc;

                        union(id, nid);
                    }
                }
            }
        }

        int ans = 0;

        // Step 2: Existing island sizes
        for (int i = 0; i < n * n; i++) {
            if (grid[i / n][i % n] == 1) {
                ans = Math.max(ans, size[find(i)]);
            }
        }

        // Step 3: Try converting every 0 into 1
        for (int r = 0; r < n; r++) {

            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 1)
                    continue;

                Set<Integer> set = new HashSet<>();

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1) {

                        int root = find(nr * n + nc);

                        set.add(root);
                    }
                }

                int current = 1; // flipped zero

                for (int root : set) {
                    current += size[root];
                }

                ans = Math.max(ans, current);
            }
        }

        return ans;
    }
}