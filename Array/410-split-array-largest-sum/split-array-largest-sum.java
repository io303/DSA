import java.util.*;

public class Solution {

    public static int splitArray(int[] nums, int k) {
        int l = 0, r = 0;

        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;
                r = mid - 1; // try smaller
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public static boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num > maxSum) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return count <= k;
    }

    
}