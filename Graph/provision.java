import java.util.ArrayList;

public class provision {
    public static void main(String[] args) {
        int n=3;
        int arr[][]={{1,1,0},{1,1,0},{0,0,1}};
         findprov(arr);
    }

    private static void findprov(int[][] arr) {
        int n=arr.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1&&i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        boolean visited[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                count++;
            }
        }
        System.out.println(count); 
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i]=true;
        for(int j:adj.get(i)){
            if(!visited[j]){
                dfs(j, adj, visited);
            }
        }
    }
}
