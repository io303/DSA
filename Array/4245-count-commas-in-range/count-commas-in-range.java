class Solution {
    public int countCommas(int n) {
       String s=String.valueOf(n);
       int num=s.length();
       if(num<4)return 0;
      
        int p=1000;
        int ans=n-p;
        
      return ans+1;
    }
}