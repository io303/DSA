class Solution {
    public int maximumLengthSubstring(String s) {
       Map<Character,Integer> mp=new HashMap<>();
       int i=0,j=0,n=s.length(),maxi=Integer.MIN_VALUE;
       while(j<n){
        char ch=s.charAt(j);
        mp.put(ch,mp.getOrDefault(ch,0)+1);

        while(mp.get(ch)>2){
            char c=s.charAt(i);
            mp.put(c,mp.get(c)-1);
            if(mp.get(c)==0){
                mp.remove(c);
            }
            i++;
        }
        maxi=Math.max(maxi,j-i+1);
        j++;
       }
       return maxi;
    }
}