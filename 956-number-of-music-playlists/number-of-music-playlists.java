
class Solution {

    static final int MOD = 1_000_000_007;
    int dp[][];

    public int numMusicPlaylists(int n, int goal, int k) {

        dp = new int[goal + 1][n + 1];

        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }

        return help(0, 0, n, goal, k);
    }

    int help(int i, int j, int n, int goal, int k) {

        if (i == goal) {
            return j == n ? 1 : 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        long ans = 0;

        // Choice 1: Pick a new song
        if (j < n) {
            ans += (long)(n - j) *
                   help(i + 1, j + 1, n, goal, k);
        }

        // Choice 2: Replay an old song
        if (j > k) {
            ans += (long)(j - k) *
                   help(i + 1, j, n, goal, k);
        }

        return dp[i][j] = (int)(ans % MOD);
    }
}
