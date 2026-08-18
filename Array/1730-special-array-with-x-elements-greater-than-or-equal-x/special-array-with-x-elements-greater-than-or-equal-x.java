class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int h = nums.length;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;

            int count = 0;
            for (int x : nums) {
                if (x >= mid) {
                    count++;
                }
            }

            if (count >= mid) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        // h is the largest x for which count >= x.
        // Check whether it is exactly equal.
        int count = 0;
        for (int x : nums) {
            if (x >= h) {
                count++;
            }
        }

        return count == h ? h : -1;
    }
}