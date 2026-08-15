class Solution {
    public int[][] highestPeak(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                    grid[i][j]=0;
                }
                 else {
                    // Unvisited land
                    grid[i][j] = -1;
                }
            }
        }
        int dir[][]={{-1,0},{0,-1},{0,1},{1,0}};
        while(!q.isEmpty()){
            int size=q.size();

            for(int k=0;k<size;k++){
                int curr[]=q.poll();
                for(int a[]:dir){
                    int ni=curr[0]+a[0];
                    int nj=curr[1]+a[1];

                    if(ni>=0&&ni<n&&nj>=0&&nj<m&&grid[ni][nj] ==-1){
                        grid[ni][nj]=Math.max(grid[ni][nj],grid[curr[0]][curr[1]]+1);
                        q.add(new int[]{ni,nj});
                    }
                }
            }
         
        }
           return grid;
    }
}