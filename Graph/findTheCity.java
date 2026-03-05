
import java.util.*;
public class findTheCity {
    public static void main(String[] args) {
        findTheCity fa=new findTheCity();
        Scanner  sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int edges[][]=new int[m][3];
        for(int i=0;i<m;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
            edges[i][2]=sc.nextInt();

        }
        int threshold=sc.nextInt();

          int reslut=  fa.fcity(n,edges,threshold);
          System.out.println(reslut);

    }

    private int fcity(int n, int[][] edges, int threshold) {
       int dist[][]=new int[n][n];
       for(int c[]:dist){
        Arrays.fill(c, Integer.MAX_VALUE);
       }
       for(int i=0;i<n;i++){
        dist[i][i]=0;
       }
       for(int i=0;i<n;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int wt=edges[i][2];
        dist[u][v]=wt;
        dist[v][u]=wt;
       }
       for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i][k]+dist[k][j]<dist[i][j]){
                    dist[i][j]=dist[i][k]+dist[k][j];
                }
            }
        }
       }
       int reReachbale=Integer.MAX_VALUE;
       int city=-1;
       for(int i=0;i<n;i++){
        int count=0;
        for(int j=0;j<n;j++){
            if(dist[i][j]<=threshold){
                count++;
            }
        }
        if(count<reReachbale){
            reReachbale=count;
            city=i;
        }
       }
       return city;
    }
}
