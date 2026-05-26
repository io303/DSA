class Solution {
    public String removeDuplicateLetters(String s) {

        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (seen[c - 'a']) continue;

            while (!stack.isEmpty()
                    && c < stack.peek()
                    && i < last[stack.peek() - 'a']) {

                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
}