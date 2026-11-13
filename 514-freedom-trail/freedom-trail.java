
class Solution {

    int dp[][];

    public int findRotateSteps(String ring, String key) {

        int n = ring.length();

        dp = new int[n][key.length()];

        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }

        return help(0, 0, ring, key);
    }

    int help(int pos, int idx, String ring, String key) {

        if (idx == key.length()) {
            return 0;
        }

        if (dp[pos][idx] != -1) {
            return dp[pos][idx];
        }

        int n = ring.length();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (ring.charAt(i) == key.charAt(idx)) {

                int diff = Math.abs(pos - i);

                int rotate = Math.min(diff, n - diff);

                int cost = rotate + 1
                         + help(i, idx + 1, ring, key);

                ans = Math.min(ans, cost);
            }
        }

        return dp[pos][idx] = ans;
    }
}
