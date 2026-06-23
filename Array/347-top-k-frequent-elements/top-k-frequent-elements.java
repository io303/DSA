class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
       PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->b.f-a.f);

       for(Map.Entry<Integer,Integer> e:mp.entrySet()){
        pq.offer(new Node(e.getKey(),e.getValue()));
       }
    int ans[]=new int[k];
    for(int i=0;i<k;i++){
        ans[i]=pq.poll().v;
    }
    return ans;

    }
}
class Node{
    int v,f;
    Node(int v,int f){
        this.v=v;
        this.f=f;
    }
}