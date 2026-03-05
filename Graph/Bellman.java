import java.util.*;
public class Bellman {
  public static void main(String[] args) {
    Bellman b=new Bellman();
    Scanner sc=new Scanner(System.in);
    int v=sc.nextInt();
    int e=sc.nextInt();
    ArrayList<Edge> ls=new ArrayList<>();
    for(int i=0;i<e;i++){
        int u=sc.nextInt();
        int vi=sc.nextInt();
        int wit=sc.nextInt();
        ls.add(new Edge(u, vi, wit));
    }
    int k=sc.nextInt();
    b.bellman(v,ls,k);

  }

  private static void bellman(int v, ArrayList<Edge> ls, int k) {
   int dist[]=new  int[v];
   Arrays.fill(dist,(int)1e9);
   dist[k]=0;
   for(int i=0;i<=v-1;i++){
    for(Edge edge:ls){
        if(dist[edge.src]!=(int)1e9&&dist[edge.src]+edge.wt<dist[edge.dest]){
            dist[edge.dest]=dist[edge.src]+edge.wt;
        }
    }
   }
//    for(int i=0;i<v;i++){
//     System.out.println(dist[i]);
//    }
   for(Edge edge:ls){
    if(dist[edge.src]!=(int)1e9 && dist[edge.src]+edge.wt<dist[edge.dest]){
       System.out.println(-1);
    }else{
        System.out.println(Arrays.toString(dist));
    }
   }


  }  
}
class Edge{
    int src,dest,wt;

    public Edge(int src,int dest,int wt) {
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
    
}
