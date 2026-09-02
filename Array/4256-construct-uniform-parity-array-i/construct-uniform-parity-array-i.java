class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        boolean allo=true;
        boolean alle=true;

        for(int a:nums1){
            if(a%2==0){
                allo=false;
            }
            if(a%2==1){
                alle=false;
            }
        }
        if(allo||alle)return true;
        return true;
    }
}