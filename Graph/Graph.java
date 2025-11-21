

import java.util.*;

public class Graph {
    ArrayList<ArrayList<Integer>> adj;
    int n;

  
    public Graph(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    void printgraoh(){
        for(int i=0;i<n;i++){
            System.out.println(i+"->"+adj.get(i));
        }
    }
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2 );
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.printgraoh();
    }

}
