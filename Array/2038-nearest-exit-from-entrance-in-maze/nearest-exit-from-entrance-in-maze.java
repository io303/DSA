class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int n = maze.length;
        int m = maze[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{entrance[0], entrance[1], 0});

        // Mark entrance visited
        maze[entrance[0]][entrance[1]] = '+';

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int i = curr[0];
            int j = curr[1];
            int dist = curr[2];

            for (int[] d : dir) {

                int ni = i + d[0];
                int nj = j + d[1];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                    continue;
                }

                if (maze[ni][nj] == '+') {
                    continue;
                }

                // If boundary -> exit
                if (ni == 0 || ni == n - 1 ||
                    nj == 0 || nj == m - 1) {

                    return dist + 1;
                }

                maze[ni][nj] = '+';

                q.add(new int[]{ni, nj, dist + 1});
            }
        }

        return -1;
    }
}