import java.util.Stack;

public class Prefix {
    public static void main(String[] args) {
        String exp = "9-(5+3)*4/6";
        System.out.println("Infix: " + exp);
        System.out.println("Prefix: " + infixToPrefix(exp));
    }

    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '^') return 3;
        return -1;
    }

    public static String infixToPrefix(String s) {
        Stack<String> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // if operand (A-Z or 0-9)
            if (Character.isLetterOrDigit(ch)) {
                operand.push(ch + "");
            }

            else if (ch == '(') {
                operator.push(ch);
            }

            else if (ch == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    char op = operator.pop();
                    String v2 = operand.pop();
                    String v1 = operand.pop();
                    String pre = op + v1 + v2;
                    operand.push(pre);
                }
                operator.pop(); // remove '('
            }

            else { // operator (+, -, *, /, ^)
                while (!operator.isEmpty() &&
                       precedence(operator.peek()) >= precedence(ch)) {
                    if (operator.peek() == '(') break;
                    char op = operator.pop();
                    String v2 = operand.pop();
                    String v1 = operand.pop();
                    String pre = op + v1 + v2;
                    operand.push(pre);
                }
                operator.push(ch);
            }
        }

        // remaining operators
        while (!operator.isEmpty()) {
            char op = operator.pop();
            String v2 = operand.pop();
            String v1 = operand.pop();
            String pre = op + v1 + v2;
            operand.push(pre);
        }

        return operand.peek();
    }
}
