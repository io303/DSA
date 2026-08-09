class Solution {
    public int longestSubarray(int[] nums) {

        int c = 0;
        int i = 0, j = 0;
        int ans = 0;
        int n = nums.length;

        while (j < n) {

            if (nums[j] == 0) {
                c++;
            }

            while (c > 1) {

                if (nums[i] == 0) {
                    c--;
                }

                i++;
            }

            ans = Math.max(ans, j - i + 1);

            j++;
        }

        return ans - 1;
    }
}