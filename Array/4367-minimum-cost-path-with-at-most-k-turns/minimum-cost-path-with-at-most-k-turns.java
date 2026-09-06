import java.util.*;

class Solution {

    // 0 = UP
    // 1 = DOWN
    // 2 = LEFT
    // 3 = RIGHT
    // 4 = START

    static class State {
        int i, j, turns, dir;
        long cost;

        State(int i, int j, int turns, int dir, long cost) {
            this.i = i;
            this.j = j;
            this.turns = turns;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        long INF = Long.MAX_VALUE / 4;

        // dist[i][j][turns][direction]
        long[][][][] dist =
                new long[m][n][k + 1][5];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 0; t <= k; t++) {
                    Arrays.fill(dist[i][j][t], INF);
                }
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.cost, b.cost)
        );

        // Starting cell
        dist[0][0][0][4] = grid[0][0];

        pq.offer(new State(
            0, 0, 0, 4, grid[0][0]
        ));

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            State cur = pq.poll();

            int i = cur.i;
            int j = cur.j;
            int turns = cur.turns;
            int dir = cur.dir;
            long cost = cur.cost;

            // Stale state
            if (cost != dist[i][j][turns][dir]) {
                continue;
            }

            // First time destination is popped
            // => minimum cost because Dijkstra
            if (i == m - 1 && j == n - 1) {
                return (int) cost;
            }

            // Try 4 directions
            for (int newDir = 0; newDir < 4; newDir++) {

                int ni = i + di[newDir];
                int nj = j + dj[newDir];

                // Out of bounds
                if (ni < 0 || ni >= m ||
                    nj < 0 || nj >= n) {
                    continue;
                }

                int newTurns = turns;

                // If direction changes => turn
                if (dir != 4 && dir != newDir) {
                    newTurns++;
                }

                // More than k turns
                if (newTurns > k) {
                    continue;
                }

                long newCost = cost + grid[ni][nj];

                if (newCost < dist[ni][nj][newTurns][newDir]) {

                    dist[ni][nj][newTurns][newDir] = newCost;

                    pq.offer(new State(
                        ni,
                        nj,
                        newTurns,
                        newDir,
                        newCost
                    ));
                }
            }
        }

        return -1;
    }
}