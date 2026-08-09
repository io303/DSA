class Solution {
    public int minimumCardPickup(int[] cards) {
        int i=0,j=0,n=cards.length;
        int ans=Integer.MAX_VALUE;
        Map<Integer,Integer> mp=new HashMap<>();
        while(j<n){
            mp.put(cards[j],mp.getOrDefault(cards[j],0)+1);

                
            while(mp.size()<j-i+1){
                ans=Math.min(ans,j-i+1);
                mp.put(cards[i],mp.get(cards[i])-1);
                if(mp.get(cards[i])==0){
                    mp.remove(cards[i]);
                }
                i++;
            }
            j++;
            
        }
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
}