import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));

        HashMap<String, Integer> dp = new HashMap<>();

        int ans = 1;

        for (String word : words) {

            int curr = 1;

            for (int i = 0; i < word.length(); i++) {

                String prev = word.substring(0, i) 
                            + word.substring(i + 1);

                if (dp.containsKey(prev)) {
                    curr = Math.max(curr, dp.get(prev) + 1);
                }
            }

            dp.put(word, curr);

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}