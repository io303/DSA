class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
       int c=0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]>nums[(i+1)%n]){
            c++;
        }
       } 
       return c<=1;
    }
}