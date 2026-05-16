class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1="";
        String  s2="";
        for(String ch:word1){
            s1=s1+ch;
        }
         for(String ch:word2){
            s2=s2+ch;
        }
        return  s1.equals(s2);
    }
}