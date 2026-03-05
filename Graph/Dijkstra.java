import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        
        Dijkstra dj=new Dijkstra();
        Scanner  sc=new Scanner(System.in);
        int v=sc.nextInt();
        int  e=sc.nextInt();
        ArrayList<ArrayList<Pair>> ls=new ArrayList<>();
        for(int i=0;i<v;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int vi=sc.nextInt();
            int dis=sc.nextInt();
            ls.get(u).add(new Pair(dis,vi));
            ls.get(vi).add(new Pair(dis,u));
        }
        System.out.println(ls);


    }
}
class Pair{
    int dis;
    int node;
    Pair(int dis,int node){
        this.dis=dis;
        this.node=node;
    }
}
