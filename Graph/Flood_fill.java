import java.util.Scanner;

public class Flood_fill {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] image=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                image[i][j]=sc.nextInt();
            }
        }
        int sr=sc.nextInt();
        int sc1=sc.nextInt();
        int newColor=sc.nextInt();
        floodfill(image,sr,sc1,newColor);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] floodfill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length;
        int n=image[0].length;
        int oldcolor=image[sr][sc];
        if(oldcolor==newColor){
            return image;
        }
        dfs(image,sr,sc,oldcolor,newColor);
        return image;

    }

    private static void dfs(int[][] image, int sr, int sc, int oldcolor, int newColor) {
      int m=image.length;
      int n=image[0].length;
      if(sr<0||sr>=m||sc<0||sc>=n){
        return;
      }
      if(image[sr][sc]!=oldcolor){
        return;
      }
      image[sr][sc]=newColor;
      dfs(image, sr+1, sc, oldcolor, newColor);
      dfs(image, sr-1, sc, oldcolor, newColor);
      dfs(image, sr, sc+1, oldcolor, newColor);
      dfs(image, sr, sc-1, oldcolor, newColor);
    }
    }

