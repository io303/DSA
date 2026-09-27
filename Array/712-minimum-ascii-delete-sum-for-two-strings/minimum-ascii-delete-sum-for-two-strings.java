class Solution {

    int[][] memo;

    public int minimumDeleteSum(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        memo = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                memo[i][j] = -1;
            }
        }

        return solve(0, 0, s1, s2);
    }

    private int solve(int i, int j, String s1, String s2) {

        if (i == s1.length() && j == s2.length()) {
            return 0;
        }

        if (i == s1.length()) {
            return (int) s2.charAt(j) + solve(i, j + 1, s1, s2);
        }

        if (j == s2.length()) {
            return (int) s1.charAt(i) + solve(i + 1, j, s1, s2);
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {

            return memo[i][j] =
                solve(i + 1, j + 1, s1, s2);

        } else {

            int deleteS1 =
                (int) s1.charAt(i) +
                solve(i + 1, j, s1, s2);

            int deleteS2 =
                (int) s2.charAt(j) +
                solve(i, j + 1, s1, s2);

            return memo[i][j] = Math.min(deleteS1, deleteS2);
        }
    }
}