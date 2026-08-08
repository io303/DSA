import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {

        int i = 0;
        int ans = 0;
        int maxFreq = 0;

        Map<Character, Integer> mp = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {

            char c = s.charAt(j);

            mp.put(c, mp.getOrDefault(c, 0) + 1);

            // Maximum frequency in current window
            maxFreq = Math.max(maxFreq, mp.get(c));

            // Characters that need replacement
            while ((j - i + 1) - maxFreq > k) {

                char ch = s.charAt(i);

                mp.put(ch, mp.get(ch) - 1);

                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}