class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        PriorityQueue<Pair>  pq=new PriorityQueue<>((a,b)->b.val-a.val);
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);

        }
        for(Map.Entry<Character,Integer> e:mp.entrySet()){
            pq.offer(new Pair(e.getKey(),e.getValue()));
        }
        String ans="";
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            while(p.val>0){
                ans+=p.ch;
                p.val--;
            }
            
        }
        return ans;
    }
}
class Pair{
    char ch;
    int val;
    Pair(char ch,int val){
        this.ch=ch;
        this.val=val;
    }
}