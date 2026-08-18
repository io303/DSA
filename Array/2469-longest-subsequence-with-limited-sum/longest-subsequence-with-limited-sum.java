class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = 0, end = nums.length - 1;
            int totalEle = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] <= queries[i]) {
                    totalEle = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            result[i] = (totalEle != -1) ? totalEle + 1 : 0;
        }
        return result;
    }
}