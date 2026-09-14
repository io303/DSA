import java.util.*;

class Solution {

    public long numberOfSubarrays(int[] nums) {

        Deque<int[]> stack = new ArrayDeque<>();

        long ans = 0;

        for (int x : nums) {

            // Remove smaller values
            while (!stack.isEmpty() && stack.peek()[0] < x) {
                stack.pop();
            }

            // No same value available
            if (stack.isEmpty() || stack.peek()[0] > x) {
                stack.push(new int[]{x, 1});
            }

            // Same value available
            else {
                stack.peek()[1]++;
            }

            // All possibilities ending at x
            ans += stack.peek()[1];
        }

        return ans;
    }
}