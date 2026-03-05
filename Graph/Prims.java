import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prims {
    public static void main(String[] args) {
        Prims p=new Prims();
        Scanner sc=new Scanner(System.in);

        int v=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int vi=sc.nextInt();
            int wt=sc.nextInt();
            adj.get(u).add(new Pair(wt,vi));
            adj.get(vi).add(new Pair(wt,u));
        }
        int res=p.prim(v,adj);
        System.out.println(res);
    }

    private int prim(int v, ArrayList<ArrayList<Pair>> adj) {
        boolean visited[]=new boolean[v];
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.wt-y.wt);

        pq.add(new Pair(0,0));
        int sum=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int w=p.wt;
            int node=p.node;
            if(visited[node]) continue;
            visited[node]=true;
            sum+=w;
            for(Pair pt:adj.get(node)){
                int adjNode =pt.node;
                int adjw=pt.wt;
                if(!visited[adjNode]){
                    pq.add(new Pair(adjw,adjNode));
                }
            }

        }
        return sum;
    }
}
class Pair{
    int wt,node;
    Pair(int wt,int node){
        this.wt=wt;
        this.node=node;
    }
}
