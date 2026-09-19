import java.util.*;

class Solution {

    public int shortestPathAllKeys(String[] grid) {

        int m = grid.length;
        int n = grid[0].length();

        int startR = 0;
        int startC = 0;

        int totalKeys = 0;

        // Find start and number of keys
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                char ch = grid[r].charAt(c);

                if (ch == '@') {
                    startR = r;
                    startC = c;
                }

                if (ch >= 'a' && ch <= 'f') {
                    totalKeys++;
                }
            }
        }

        int allKeys = (1 << totalKeys) - 1;

        // visited[row][col][keys]
        boolean[][][] visited =
                new boolean[m][n][1 << totalKeys];

        Queue<int[]> q = new LinkedList<>();

        // row, col, mask
        q.offer(new int[]{startR, startC, 0});

        visited[startR][startC][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];

                // All keys collected
                if (mask == allKeys) {
                    return steps;
                }

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    // Boundary
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    char ch = grid[nr].charAt(nc);

                    // Wall
                    if (ch == '#') {
                        continue;
                    }

                    int newMask = mask;

                    // Key
                    if (ch >= 'a' && ch <= 'f') {

                        int key = ch - 'a';

                        newMask = mask | (1 << key);
                    }

                    // Door
                    if (ch >= 'A' && ch <= 'F') {

                        int key = ch - 'A';

                        // Don't have the key
                        if ((mask & (1 << key)) == 0) {
                            continue;
                        }
                    }

                    // Already visited same state
                    if (visited[nr][nc][newMask]) {
                        continue;
                    }

                    visited[nr][nc][newMask] = true;

                    q.offer(new int[]{
                            nr,
                            nc,
                            newMask
                    });
                }
            }

            steps++;
        }

        return -1;
    }
}