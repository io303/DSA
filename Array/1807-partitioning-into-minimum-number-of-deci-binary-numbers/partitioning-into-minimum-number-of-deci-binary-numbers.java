class Solution {
    public int minPartitions(String n) {
        int maxi=0;
        char ch[]=n.toCharArray();
       for(char c:ch){
        int x=c-'1';
        maxi=Math.max(maxi,x);
       }
       return maxi+1;
    }
}