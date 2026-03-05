import java.util.*;
public class Shortestpathug {
    
public static void main(String[] args) {
    Shortestpathug p=new Shortestpathug();
    Scanner sc=new Scanner(System.in);
    int v=sc.nextInt();
    int e=sc.nextInt();
    ArrayList<ArrayList<Integer>> ls=new ArrayList<>();
    for(int i=0;i<v;i++){
        ls.add(new ArrayList<>());
    }

    for(int i=0;i<e;i++){
        int u=sc.nextInt();
        int vi=sc.nextInt();

        ls.get(u).add(vi);
        ls.get(vi).add(u);
    }
    int src=sc.nextInt();
    p.find(v,ls,src);

}

private void find(int v, ArrayList<ArrayList<Integer>> ls, int src) {
    int dist[]=new int[v];
    Arrays.fill(dist,Integer.MAX_VALUE);
    Queue<Integer> q=new LinkedList<>();
    q.add(src);
    dist[src]=0;
    while(!q.isEmpty()){
        int node=q.poll();
        for(int neigh:ls.get(node)){
            if(dist[neigh]==Integer.MAX_VALUE){
                dist[neigh]=dist[node]+1;
                q.add(neigh);
            }
        }
    }
    for(int i=0;i<v;i++){
        if(dist[i]==Integer.MAX_VALUE){
            dist[i]=-1;
        }
    }
    System.out.println(Arrays.toString(dist));
}
}
