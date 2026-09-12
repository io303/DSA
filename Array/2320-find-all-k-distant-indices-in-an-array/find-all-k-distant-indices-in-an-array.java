class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        int prev = -1;

        for (int j = 0; j < n; j++) {

            if (nums[j] == key) {

                int left = Math.max(0, j - k);
                int right = Math.min(n - 1, j + k);

                // Only add indices not already added
                for (int i = Math.max(left, prev + 1); i <= right; i++) {
                    ans.add(i);
                }

                prev = Math.max(prev, right);
            }
        }

        return ans;
    }
}