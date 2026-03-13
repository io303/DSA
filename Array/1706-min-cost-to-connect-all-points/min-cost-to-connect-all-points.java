class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean visit[]=new boolean[n];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new Pair(0,0));
        int cost=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int wt=p.wt;
            if(visit[node]) continue;
            visit[node]=true;
            cost+=p.wt;

            for(int i=0;i<n;i++){
                if(!visit[i]){
                    int dist=Math.abs(points[node][0]-points[i][0])+Math.abs(points[node][1]-points[i][1]);
                    pq.add(new Pair(dist,i));
                }
            }
        }
        return cost;

    }
}
class Pair{
    int wt,node;
    Pair(int wt,int node){
        this.wt=wt;
        this.node=node;
    }
}