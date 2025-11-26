import java.util.*;
public class Graph3 {
    private int v;
    private ArrayList<ArrayList<Integer>> adj;

    public Graph3(int v){
        this.v=v;
        adj =new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void printg(){
        for(int i=0;i<v;i++){
            System.out.println(i+"->"+adj.get(i));
        }
    }
    public static void main(String[] args) {
        Graph3 g= new Graph3(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.printg();
        g.bfs(0);
        g.dfs(0);
    }
    public void bfs(int s){
        boolean visited[]=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.add(s);
      while(!q.isEmpty()){
        int node=q.poll();
        System.out.print(node+" ");
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                visited[neighbor]=true;
                q.add(neighbor);
            }
        }
      }
      System.out.println();
    }
    public void dfs(int s){
       boolean visited[]=new boolean[v];
       dfs1(s,visited);
       System.out.println();

    }
    public void dfs1(int node,boolean visited[]){
        visited[node]=true;
        System.out.println(node+" ");
        for(int neig:adj.get(node)){
            if(!visited[neig]){
                dfs1(neig,visited);
            }
        }
    }

}
