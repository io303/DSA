class Solution {

    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    int dfs(int[][] grid, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;

        // Outside grid => one perimeter
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 1;
        }

        // Water => one perimeter
        if (grid[i][j] == 0) {
            return 1;
        }

        // Already visited
        if (grid[i][j] == 2) {
            return 0;
        }

        // Mark visited
        grid[i][j] = 2;

        return dfs(grid, i - 1, j)
             + dfs(grid, i + 1, j)
             + dfs(grid, i, j - 1)
             + dfs(grid, i, j + 1);
    }
}