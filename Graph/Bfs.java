
import java.util.ArrayList;

public class Bfs {
    public static void bfs(ArrayList<ArrayList<Integer>> adj,int n,int s){
        boolean visited[]=new boolean[n];
        ArrayList<Integer> bfs=new ArrayList<>();
        ArrayList<Integer> queue=new ArrayList<>();
        visited[s]=true;
        queue.add(s);
        while(queue.size()>0){
            int node=queue.remove(0);
            bfs.add(node);
            for(int it:adj.get(node)){
                if(visited[it]==false){
                    visited[it]=true;
                    queue.add(it);
                }
            }
        }
        System.out.println(bfs);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=5;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);
        bfs(adj,n,0);
    }
}
