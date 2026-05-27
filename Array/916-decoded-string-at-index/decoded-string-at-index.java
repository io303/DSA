class Solution {
    public String decodeAtIndex(String s, int k) {

        long size = 0;

        // Step 1: Find total decoded length
        for (char ch : s.toCharArray()) {

            if (Character.isLetter(ch)) {
                size++;
            } else {
                size *= (ch - '0');
            }
        }

        // Step 2: Traverse backward
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            k %= size;

            // If k becomes 0 and current char is letter
            if (k == 0 && Character.isLetter(ch)) {
                return String.valueOf(ch);
            }

            if (Character.isDigit(ch)) {
                size /= (ch - '0');
            } else {
                size--;
            }
        }

        return "";
    }
}