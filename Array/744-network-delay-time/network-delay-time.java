class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int a[]:times){
            int u=a[0];
            int v=a[1];
            int wt=a[2];
            adj.get(u).add(new Pair(v,wt));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int wt=curr.wt;

            for(Pair it:adj.get(node)){
                    int anode=it.node;
                    int awt=it.wt;
                    if(dist[node]+awt<dist[anode]){
                        dist[anode]=dist[node]+awt;
                        pq.add(new Pair(anode,dist[anode]));
                    }
            }
        }
       int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
class Pair{
    int node,wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}