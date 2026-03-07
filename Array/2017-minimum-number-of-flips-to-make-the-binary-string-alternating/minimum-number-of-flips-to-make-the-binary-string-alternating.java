class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String s2 = s + s;

        char[] alt1 = new char[2 * n];
        char[] alt2 = new char[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            alt1[i] = (i % 2 == 0) ? '0' : '1';
            alt2[i] = (i % 2 == 0) ? '1' : '0';
        }

        int diff1 = 0, diff2 = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < 2 * n; right++) {

            if (s2.charAt(right) != alt1[right]) diff1++;
            if (s2.charAt(right) != alt2[right]) diff2++;

            if (right - left + 1 > n) {
                if (s2.charAt(left) != alt1[left]) diff1--;
                if (s2.charAt(left) != alt2[left]) diff2--;
                left++;
            }

            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}