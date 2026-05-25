class Solution {
    public boolean repeatedSubstringPattern(String s) {
      int n=s.length();
      for(int i=1;i<n;i++){
        String ch=s.substring(0,i);
        if(ans(ch,s))return true;
      } 
      return false; 
    }
    boolean ans(String ch,String s){
        String c=ch;
        int n=s.length();
      int  m=ch.length();
        for(int i=m;i<n;i=i+m){
            ch=ch+c;
            if(ch.equals(s))return true;
            
        }
        return false;
    }
}