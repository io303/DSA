class Solution {

    int index = 0;

    public int calculate(String s) {
        return solve(s);
    }

    private int solve(String s) {

        int result = 0;
        int num = 0;
        int sign = 1;

        while (index < s.length()) {

            char ch = s.charAt(index);

            // number
            if (Character.isDigit(ch)) {

                num = 0;

                while (index < s.length()
                        && Character.isDigit(s.charAt(index))) {

                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }

                result += sign * num;
                continue;
            }

            // plus
            if (ch == '+') {
                sign = 1;
            }

            // minus
            else if (ch == '-') {
                sign = -1;
            }

            // opening bracket
            else if (ch == '(') {

                index++;

                int value = solve(s);

                result += sign * value;
                continue;
            }

            // closing bracket
            else if (ch == ')') {

                index++;

                return result;
            }

            index++;
        }

        return result;
    }
}