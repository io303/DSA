import java.util.*;

class Solution {

    int row, col;

    public int latestDayToCross(int row, int col, int[][] cells) {

        this.row = row;
        this.col = col;

        int low = 1;
        int high = cells.length;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canCross(mid, cells)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canCross(int day, int[][] cells) {

        int[][] grid = new int[row][col];

        // Flood cells for this day
        for (int i = 0; i < day; i++) {

            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        // Start from all land cells in first row
        for (int c = 0; c < col; c++) {

            if (grid[0][c] == 0) {

                q.add(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            // Reached bottom row
            if (r == row - 1) {
                return true;
            }

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < row &&
                    nc >= 0 && nc < col &&
                    grid[nr][nc] == 0 &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}