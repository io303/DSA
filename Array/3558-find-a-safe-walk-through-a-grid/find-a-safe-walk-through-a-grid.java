

class Solution {

    static class State {
        int row;
        int col;
        int cost;

        State(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost);

        dist[0][0] = grid.get(0).get(0);

        pq.offer(new State(0, 0, dist[0][0]));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            State cur = pq.poll();

            int r = cur.row;
            int c = cur.col;
            int cost = cur.cost;

            if (cost > dist[r][c])
                continue;

            if (r == m - 1 && c == n - 1)
                return cost < health;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int newCost = cost + grid.get(nr).get(nc);

                if (newCost < dist[nr][nc]) {

                    dist[nr][nc] = newCost;
                    pq.offer(new State(nr, nc, newCost));
                }
            }
        }

        return false;
    }

    
}