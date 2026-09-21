class Solution {
    public int maxDistance(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[][] dir = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };

        Queue<Pair> q = new LinkedList<>();

        int land = 0;

        // Put ALL land cells into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                    q.add(new Pair(i, j, 0));
                    land++;
                }
            }
        }

        // All land OR all water
        if (land == 0 || land == n * m) {
            return -1;
        }

        int ans = 0;

        // Multi-source BFS
        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int x = curr.i;
            int y = curr.j;
            int d = curr.d;

            ans = Math.max(ans, d);

            for (int[] p : dir) {

                int nx = x + p[0];
                int ny = y + p[1];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < m &&
                    dist[nx][ny] > d + 1) {

                    dist[nx][ny] = d + 1;

                    q.add(new Pair(nx, ny, d + 1));
                }
            }
        }

        return ans;
    }
}

class Pair {
    int i, j, d;

    Pair(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.d = d;
    }
}