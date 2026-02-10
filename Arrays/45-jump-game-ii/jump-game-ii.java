class Solution {
    public int jump(int[] nums) {
       int  jump=0,j=0,i=0;

       for(int k=0;k<nums.length-1;k++){
        j=Math.max(j,k+nums[k]);

        if(k==i){
            jump++;
            i=j;
        }
       } 
       return jump;
    }
}