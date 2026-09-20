class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        int i=1;
        for(char ch:s.toCharArray()){
            int curr=26-(ch-'a');
            ans+=curr*i;
            i++;
        }
        return ans;
    }
}