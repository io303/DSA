import java.util.*;

class Solution {

    double[][] dp;

    public double soupServings(int n) {

        // Optimization:
        // For sufficiently large n, answer is extremely close to 1.
        if (n >= 4800) {
            return 1.0;
        }

        // Convert ml into units of 25 ml.
        int N = (n + 24) / 25;

        dp = new double[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1.0);
        }

        return solve(N, N);
    }

    double solve(int a, int b) {

        // Both become empty together
        if (a <= 0 && b <= 0) {
            return 0.5;
        }

        // A becomes empty first
        if (a <= 0) {
            return 1.0;
        }

        // B becomes empty first
        if (b <= 0) {
            return 0.0;
        }

        if (dp[a][b] != -1.0) {
            return dp[a][b];
        }

        double ans = 0.0;

        ans += solve(a - 4, b);
        ans += solve(a - 3, b - 1);
        ans += solve(a - 2, b - 2);
        ans += solve(a - 1, b - 3);

        ans /= 4.0;

        return dp[a][b] = ans;
    }
}