class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int lastInvalid = -1;
        int lastValid = -1;

        for (int j = 0; j < nums.length; j++) {

            // Cannot include this element
            if (nums[j] > right) {
                lastInvalid = j;
            }

            // This can serve as the maximum
            if (nums[j] >= left) {
                lastValid = j;
            }

            // All starting points from lastInvalid + 1 to lastValid
            // give valid subarrays ending at j
            ans += lastValid - lastInvalid;
        }

        return ans;
    }
}