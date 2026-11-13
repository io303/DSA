class Solution {
    public int minimumOperations(int[][] grid) {

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < cols; i++) {
            int prev = grid[0][i];

            for (int j = 1; j < rows; j++) {

                if (prev >= grid[j][i]) {
                    count += prev - grid[j][i] + 1;
                    grid[j][i] = prev + 1;
                }

                prev = grid[j][i];
            }
        }

        return count;
    }
}