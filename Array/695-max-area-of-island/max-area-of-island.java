class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];

        int maxArea = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==1 && !visited[i][j]){

                    int area = dfs(grid,i,j,m,n,visited);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    int dfs(int grid[][],int r,int c,int m,int n,boolean visited[][]){

        if(r<0 || r>=m || c<0 || c>=n || grid[r][c]==0 || visited[r][c])
            return 0;

        visited[r][c] = true;

        int area = 1;

        area += dfs(grid,r+1,c,m,n,visited);
        area += dfs(grid,r-1,c,m,n,visited);
        area += dfs(grid,r,c+1,m,n,visited);
        area += dfs(grid,r,c-1,m,n,visited);

        return area;
    }
}