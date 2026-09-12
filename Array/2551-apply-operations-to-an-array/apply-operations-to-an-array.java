class Solution {
    public int[] applyOperations(int[] nums) {
        int i=0,n=nums.length;
        for(int k=1;k<n;k++){
            if(nums[k-1]==nums[k]){
                nums[k-1]=2*nums[k-1];
                nums[k]=0;
            }

        }
       int ans[]=new int[n];
       for(int k=0;k<n;k++){
        if(nums[k]!=0){
            ans[i++]=nums[k];
        }
       }
       return ans;
    }
}