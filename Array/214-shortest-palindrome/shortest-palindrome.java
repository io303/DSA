class Solution {
    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String str = s + "#" + rev;

        int[] lps = new int[str.length()];

        int i = 1;
        int len = 0;

        while (i < str.length()) {

            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } 
            else {

                if (len > 0) {
                    len = lps[len - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int longestPalPrefix = lps[str.length() - 1];

        String remaining = s.substring(longestPalPrefix);

        String add = new StringBuilder(remaining)
                        .reverse()
                        .toString();

        return add + s;
    }
}