class Solution {
    int par[];
    int rank[];

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }

        for(List<Integer> ls:pairs){
            union(ls.get(0),ls.get(1));
        }
        Map<Integer,PriorityQueue<Character>>mp = new HashMap<>();

        for(int i=0;i<n;i++){
            int root=find(i);
            mp.putIfAbsent(root,new PriorityQueue<>());

            mp.get(root).offer(s.charAt(i));
        }

        char ans[]=new char[n];
        for(int i=0;i<n;i++){
            int root=find(i);
            ans[i]=mp.get(root).poll();
        }
        return new String(ans);

    }
    int find(int x){
        if(par[x]==x)return x;
        return par[x]=find(par[x]);
    }
    void union(int a,int b){
        int pa=find(a);
        int pb=find(b);

        if(pa==pb)return;

        if(rank[pa]<rank[pb]){
            par[pa]=pb;
        }
        else if(rank[pa]>rank[pb]){
            par[pb]=pa;
        }else{
            par[pb]=pa;
            rank[pa]++;
        }
    }
}