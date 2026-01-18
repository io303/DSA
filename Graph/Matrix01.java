import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public static void main(String[] args) {
        int m=3;
        int n=3;
        int[][] matrix={
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };

       System.out.println(matrix(matrix,m,n));
    }

    private static int[][] matrix(int[][] matrix, int m, int n) {
       int dist[][]=new int[m][n];
       Queue<int[]> q=new LinkedList<>();
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(matrix[i][j]==0){
                dist[i][j]=0;
                q.add(new int[]{i,j});
            }
            else{
                dist[i][j]=-1;
            }
        }
       }
       int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
       while(!q.isEmpty()){
        int[] current=q.poll();
        int x=current[0];
        int y=current[1];
        for(int[] dir:directions){
            int newX=x+dir[0];
            int newY=y+dir[1];
            if(newX>=0 && newX<m && newY>=0 && newY<n && dist[newX][newY]==-1){
                dist[newX][newY]=dist[x][y]+1;
                q.add(new int[]{newX,newY});
            }
        }
       }
       return dist;
    }
}
