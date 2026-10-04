import java.util.*;

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        Map<Integer, List<String>> memo = new HashMap<>();

        return solve(s, 0, set, memo);
    }

    private List<String> solve(String s, int index,
                               Set<String> set,
                               Map<Integer, List<String>> memo) {

        if (index == s.length()) {
            return Arrays.asList("");
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        List<String> result = new ArrayList<>();

        for (int i = index + 1; i <= s.length(); i++) {

            String word = s.substring(index, i);

            if (!set.contains(word)) {
                continue;
            }

            List<String> remaining = solve(s, i, set, memo);

            for (String next : remaining) {

                if (next.isEmpty()) {
                    result.add(word);
                } else {
                    result.add(word + " " + next);
                }
            }
        }

        memo.put(index, result);

        return result;
    }
}