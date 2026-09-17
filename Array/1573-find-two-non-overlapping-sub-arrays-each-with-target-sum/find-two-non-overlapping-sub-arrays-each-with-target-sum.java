class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int i = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {

            sum += arr[j];

            while (sum > target) {
                sum -= arr[i];
                i++;
            }

            if (sum == target) {

                int len = j - i + 1;

                // Previous subarray must be before i
                if (i > 0 && best[i - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[i - 1]);
                }

                minLen = Math.min(minLen, len);
            }

            best[j] = minLen;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}