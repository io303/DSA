class Solution {
    int parent[];
    int rank[];
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];
        int n=equations.length;

        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            String st=equations[i];
            if(st.charAt(1)=='='){
                union(st.charAt(0)-'a',st.charAt(3)-'a');
            }
        }
          for(int i=0;i<n;i++){
            String st=equations[i];
            if(st.charAt(1)=='!'){
              if(find(st.charAt(0)-'a')==find(st.charAt(3)-'a'))return false;
            }
        }

    return true;
    }
    int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }
    void union(int a,int b){
        int pa=find(a);
        int pb=find(b);

        if(pa==pb)return;

        if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }else if(rank[pa]>rank[pb]){
            parent[pb]=pa;
        }else{
            parent[pb]=pa;
            rank[pa]++;
        }
    }
}