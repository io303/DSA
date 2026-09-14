import java.util.*;

class Solution {
    public String smallestNumber(String pattern) {

        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        int num = 1;

        for (int i = 0; i <= pattern.length(); i++) {

            st.push(num++);

            // I means stop the decreasing sequence
            if (i == pattern.length() || pattern.charAt(i) == 'I') {

                while (!st.isEmpty()) {
                    ans.append(st.pop());
                }
            }
        }

        return ans.toString();
    }
}