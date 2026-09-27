import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        int n = envelopes.length;

        int[] dp = new int[n];
        int size = 0;

        for (int[] envelope : envelopes) {

            int height = envelope[1];

            int left = 0;
            int right = size;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (dp[mid] >= height) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            dp[left] = height;

            if (left == size) {
                size++;
            }
        }

        return size;
    }
}