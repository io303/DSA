class Solution {
    public int majorityElement(int[] nums) {
        int c=0;
        int canditate=0;
        for(int num:nums){
            if(c==0){
                canditate=num;
            }
             if(num==canditate){
                c++;
            }else{
                c--;
            }
        }
        return canditate;
    }
}