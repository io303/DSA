class Solution {

    int m, n;
    int[][] fireTime;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int maximumMinutes(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        // Step 1: Find when fire reaches every cell
        fireTime = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(fireTime[i], Integer.MAX_VALUE);
        }

        bfsFire(grid);

        // Step 2: Binary search answer
        int lo = 0;
        int hi = m * n;
        int ans = -1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (canEscape(grid, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if (ans == m * n) {
            return 1_000_000_000;
        }

        return ans;
    }

    // Multi-source BFS
    void bfsFire(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                if (grid[nr][nc] == 2) {
                    continue;
                }

                if (fireTime[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                fireTime[nr][nc] = fireTime[r][c] + 1;

                q.offer(new int[]{nr, nc});
            }
        }
    }

    boolean canEscape(int[][] grid, int wait) {

        // If fire reaches start before we leave
        if (fireTime[0][0] <= wait) {
            return false;
        }

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[m][n];

        q.offer(new int[]{0, 0, wait});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }

                if (grid[nr][nc] == 2) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                int nextTime = time + 1;

                // Safehouse has special rule
                if (nr == m - 1 && nc == n - 1) {

                    if (nextTime <= fireTime[nr][nc]) {
                        return true;
                    }

                } else {

                    if (nextTime < fireTime[nr][nc]) {

                        visited[nr][nc] = true;

                        q.offer(
                            new int[]{nr, nc, nextTime}
                        );
                    }
                }
            }
        }

        return false;
    }
}