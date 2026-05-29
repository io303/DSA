class Solution {
    public int minSteps(String s, String t) {
        int si[]=new int[26];
        int ti[]=new int[26];
        int c=0;
        for(char ch:s.toCharArray()){
            si[ch-'a']++;
        }
         for(char ch:t.toCharArray()){
            ti[ch-'a']++;
        }
       
        for(int i=0;i<26;i++){
            int x=ti[i]-si[i];
            if(x>0){
                c=c+x;
            }
        }
        return c;
    }
}