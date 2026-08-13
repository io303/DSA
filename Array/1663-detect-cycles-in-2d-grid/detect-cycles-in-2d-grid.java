class Solution {

    public boolean containsCycle(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int[][] dir = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visited[i][j]) {

                    if (bfs(i, j, grid, visited, dir)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean bfs(int si, int sj,
                       char[][] grid,
                       boolean[][] visited,
                       int[][] dir) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(si, sj, -1, -1));
        visited[si][sj] = true;

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int i = curr.i;
            int j = curr.j;

            int pi = curr.pi;
            int pj = curr.pj;

            for (int[] d : dir) {

                int ni = i + d[0];
                int nj = j + d[1];

                // Outside grid
                if (ni < 0 || ni >= grid.length ||
                    nj < 0 || nj >= grid[0].length) {
                    continue;
                }

                // Different character
                if (grid[ni][nj] != grid[i][j]) {
                    continue;
                }

                // Parent -> ignore
                if (ni == pi && nj == pj) {
                    continue;
                }

                // Already visited -> cycle
                if (visited[ni][nj]) {
                    return true;
                }

                // First time visiting
                visited[ni][nj] = true;

                q.add(new Pair(ni, nj, i, j));
            }
        }

        return false;
    }
}

class Pair {

    int i, j;
    int pi, pj;

    Pair(int i, int j, int pi, int pj) {
        this.i = i;
        this.j = j;
        this.pi = pi;
        this.pj = pj;
    }
}