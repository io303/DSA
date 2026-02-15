class Solution {
   Boolean dp[][];

public boolean checkValidString(String s) {
    dp = new Boolean[s.length()][s.length()];
    return help(s.toCharArray(), 0, 0);
}

boolean help(char[] s, int i, int c) {
    if (c < 0) return false;
    if (i == s.length) return c == 0;
    if (dp[i][c] != null) return dp[i][c];

    boolean ans;

    if (s[i] == '(')
        ans = help(s, i + 1, c + 1);
    else if (s[i] == ')')
        ans = help(s, i + 1, c - 1);
    else
        ans = help(s, i + 1, c + 1) ||
              help(s, i + 1, c - 1) ||
              help(s, i + 1, c);

    return dp[i][c] = ans;
}

}