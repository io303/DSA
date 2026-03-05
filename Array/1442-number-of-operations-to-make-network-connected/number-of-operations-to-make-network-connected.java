class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int parent[]=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int e[]:connections){
            union(e[0],e[1],parent);
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) c++;
        }
        return c-1;
        
    }
    void union(int a,int b,int parent[]){
        int pa=findParent(a,parent);
        int pb=findParent(b,parent);

        if(pa!=pb){
            parent[pb]=pa;
        }
    }
    int findParent(int n,int parent[]){
        if(parent[n]==n) return n;
        return parent[n]=findParent(parent[n],parent);
    }
}