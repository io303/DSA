class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int cmsum = nums[0];
        int msum = nums[0];

        int cnsum = nums[0];
        int nsum = nums[0];

        int t = nums[0];

        for(int i = 1; i < n; i++) {

            // max subarray
            cmsum = Math.max(nums[i], cmsum + nums[i]);
            msum = Math.max(msum, cmsum);

            // min subarray
            cnsum = Math.min(nums[i], cnsum + nums[i]);
            nsum = Math.min(nsum, cnsum);

            t += nums[i];
        }

        // edge case: all negative
        if(msum < 0) return msum;

        return Math.max(msum, t - nsum);
    }
}