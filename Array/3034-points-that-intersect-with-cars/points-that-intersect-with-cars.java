import java.util.*;

class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {

        int[] diff = new int[102];

        // Mark start and end
        for (List<Integer> car : nums) {

            int start = car.get(0);
            int end = car.get(1);

            diff[start]++;
            diff[end + 1]--;
        }

        int active = 0;
        int ans = 0;

        // Prefix sum
        for (int i = 1; i <= 100; i++) {

            active += diff[i];

            if (active > 0) {
                ans++;
            }
        }

        return ans;
    }
}