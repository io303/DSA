public class No_Of_Island {
    public static void main(String[] args) {
        int[][] grid={
            {1,0,1},
            {0,1,0},
            {1,0,1}};

           System.out.println(NoOfIsland(grid));
        }

    private static int NoOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean [][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&& !visited[i][j]){
                    count++;
                    dfs(grid,visited,i,j,n,m);
                }
            }
        }
        return count;

    }

    static void dfs(int[][] grid, boolean[][] visited, int i, int j, int n, int m) {
         if(i<0||j<0||i>=n||j>=m||grid[i][j]==0||visited[i][j]==true){
            return;
         }
         visited[i][j]=true;
         int[] dx={-1,-1,-1,0,0,1,1,1};
         int [] dy={-1,0,1,-1,1,-1,0,1};

         for(int k=0;k<8;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            dfs(grid,visited,x,y,n,m);
         }
    }
    }

