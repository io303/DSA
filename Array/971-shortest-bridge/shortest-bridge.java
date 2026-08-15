class Solution {

    int n, m;
    Queue<int[]> q = new LinkedList<>();

    public int shortestBridge(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        boolean found = false;

        // Find first island
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
        }

        int[][] dir = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };

        int step = 0;

        // Multi-source BFS
        while (!q.isEmpty()) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                int[] curr = q.poll();

                int i = curr[0];
                int j = curr[1];

                for (int[] d : dir) {

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && ni < n &&
                        nj >= 0 && nj < m) {

                        // Reached second island
                        if (grid[ni][nj] == 1) {
                            return step;
                        }

                        // Visit water
                        if (grid[ni][nj] == 0) {
                            grid[ni][nj] = 2;
                            q.add(new int[]{ni, nj});
                        }
                    }
                }
            }

            step++;
        }

        return -1;
    }

    void dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= n ||
            j < 0 || j >= m ||
            grid[i][j] != 1) {
            return;
        }

        // Mark first island
        grid[i][j] = 2;

        // Add to BFS queue
        q.add(new int[]{i, j});

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}