class Solution {
    public int maxDepth(String s) {
        int max=0,d=0,c=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                d++;
                max=Math.max(max,d);
            }
            if(ch==')'){
                d--;
            }
        }
        return max;
    }
}