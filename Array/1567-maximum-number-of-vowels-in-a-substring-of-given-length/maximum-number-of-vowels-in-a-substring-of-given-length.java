class Solution {
    public int maxVowels(String s, int k) {
        int l=0,r=0,c=0,mc=0;

        while(r<s.length()){

            char ch=s.charAt(r);
            if(isVowel(ch)){
                c++;
            }

            if(r-l+1>k){
                if(isVowel(s.charAt(l))){
                    c--;
                }
                l++;
            }
            if(r-l+1==k){
                mc=Math.max(mc,c);
            }
            r++;
        }
        return mc;
    }
    boolean isVowel(char ch){
        return  "aeiouAEIOU".indexOf(ch)!=-1;
    }
}