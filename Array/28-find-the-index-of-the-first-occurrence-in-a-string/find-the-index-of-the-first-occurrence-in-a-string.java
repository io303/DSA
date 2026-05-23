class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
          if(needle.equals(haystack))return 0;
        for(int i=0;i<=n-m;i++){
            if(needle.equals(haystack.substring(i,i+m)))return i;
        }
        return -1;
    }
}