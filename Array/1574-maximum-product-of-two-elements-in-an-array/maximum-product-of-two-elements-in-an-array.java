class Solution {
    public int maxProduct(int[] nums) {
        int f=0,s=0;
        for(int a:nums){
            if(a>=f){
                s=f;
                f=a;
            }else if(a<f&&a>=s){
                s=a;
            }
        }
        return (f-1)*(s-1);
    }
}