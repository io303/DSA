import java.util.Arrays;

class Solution {

    int[][] dp;

    public String longestPalindrome(String s) {

        int n = s.length();

        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (isPalindrome(s, i, j)) {

                    if (j - i + 1 > maxLen) {

                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(String s, int i, int j) {

        if (i >= j)
            return true;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if (s.charAt(i) != s.charAt(j)) {

            dp[i][j] = 0;
            return false;
        }

        boolean ans = isPalindrome(s, i + 1, j - 1);

        dp[i][j] = ans ? 1 : 0;

        return ans;
    }

   
}