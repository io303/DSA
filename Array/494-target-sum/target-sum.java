class Solution {
    int c=0;
    public int findTargetSumWays(int[] nums, int target) {
        help(nums,target,0,0);
        return c;

    }
    void help(int nums[],int t,int sum,int i){
        if(i==nums.length){
            if(sum==t){
                c++;
            }
            return;
        }

        help(nums,t,sum-nums[i],i+1);
        help(nums,t,sum+nums[i],i+1);
    }
}