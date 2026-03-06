class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)return 0;
        Arrays.sort(nums);
        int maxDiff = 0;
        for(int i=0;i<nums.length-1;i++){
            maxDiff = Math.max(maxDiff, nums[i+1] - nums[i]);
        }
        return maxDiff;
    }
}