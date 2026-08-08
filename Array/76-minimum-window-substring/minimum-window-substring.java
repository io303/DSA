class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch:t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);

        }
        int minL=Integer.MAX_VALUE;
        int start=0,c=0;

        int i=0;
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);

            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)>=0)c++;
            }


            ///

            while(c==t.length()){
                if(j-i+1<minL){
                    minL=j-i+1;
                    start=i;
                }
                char left=s.charAt(i);
                if(mp.containsKey(left)){
                    mp.put(left,mp.getOrDefault(left,0)+1);
                    if(mp.get(left)>0)c--;
                }
                i++;
            }
        }
        if(minL==Integer.MAX_VALUE)return "";
        return s.substring(start,minL+start);
    }
}