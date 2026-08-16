class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] cnt = new int[3];

        // Count remainders
        for (int x : stones) {
            cnt[x % 3]++;
        }

        // Even number of remainder-0 stones
        if (cnt[0] % 2 == 0) {
            return Math.min(cnt[1], cnt[2]) > 0;
        }

        // Odd number of remainder-0 stones
        return Math.abs(cnt[1] - cnt[2]) > 2;
    }
}