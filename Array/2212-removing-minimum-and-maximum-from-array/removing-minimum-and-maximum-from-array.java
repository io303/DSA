class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIndex = -1;
        int maxIndex = -1;

        // Find min, max and their indices
        for (int i = 0; i < n; i++) {

            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // 1. Remove both from left
        int removeFromLeft = right + 1;

        // 2. Remove both from right
        int removeFromRight = n - left;

        // 3. Remove one from left and one from right
        int removeBoth = (left + 1) + (n - right);

        return Math.min(removeFromLeft,
                Math.min(removeFromRight, removeBoth));
    }
}