class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int ones = 0;

        int bestStart = -1;
        int bestEnd = -1;
        int bestLen = Integer.MAX_VALUE;

        for (int j = 0; j < s.length(); j++) {

            if (s.charAt(j) == '1') {
                ones++;
            }

            while (ones > k) {
                if (s.charAt(i) == '1') {
                    ones--;
                }
                i++;
            }

            if (ones == k) {

                // Remove leading zeros
                while (s.charAt(i) == '0') {
                    i++;
                }

                int len = j - i + 1;

                if (len < bestLen) {
                    bestLen = len;
                    bestStart = i;
                    bestEnd = j;
                }
                else if (len == bestLen) {

                    String curr = s.substring(i, j + 1);
                    String best = s.substring(bestStart, bestEnd + 1);

                    if (curr.compareTo(best) < 0) {
                        bestStart = i;
                        bestEnd = j;
                    }
                }
            }
        }

        return bestStart == -1
                ? ""
                : s.substring(bestStart, bestEnd + 1);
    }
}