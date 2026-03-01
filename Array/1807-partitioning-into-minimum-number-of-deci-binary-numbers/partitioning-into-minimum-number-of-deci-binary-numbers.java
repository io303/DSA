class Solution {
    public int minPartitions(String n) {
        int maxi=0;
        char ch[]=n.toCharArray();
       for(char c:ch){
        int x=c-'0';
        maxi=Math.max(maxi,x);
       }
       return maxi;
    }
}