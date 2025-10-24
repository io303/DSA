import java.util.Stack;

public class Infix {
    public static void main(String[] args) {
        String s = "(9 - 5 + 3) * 4 / 6"; // Try different expressions
        System.out.println("Expression: " + s);
        System.out.println("Result: " + evaluateInfix(s));
    }

    // precedence of operators
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // apply operator to two numbers
    static int applyOp(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    static int evaluateInfix(String s) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // skip spaces
            if (ch == ' ') continue;

            // number (supports multi-digit)
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val.push(num);
            }

            // left parenthesis
            else if (ch == '(') {
                op.push(ch);
            }

            // right parenthesis
            else if (ch == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    int val2 = val.pop();
                    int val1 = val.pop();
                    char oper = op.pop();
                    val.push(applyOp(val1, val2, oper));
                }
                op.pop(); // remove '('
            }

            // operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!op.isEmpty() && precedence(op.peek()) >= precedence(ch)) {
                    if (op.peek() == '(') break;
                    int val2 = val.pop();
                    int val1 = val.pop();
                    char oper = op.pop();
                    val.push(applyOp(val1, val2, oper));
                }
                op.push(ch);
            }
        }

        // apply remaining operators
        while (!op.isEmpty()) {
            int val2 = val.pop();
            int val1 = val.pop();
            char oper = op.pop();
            val.push(applyOp(val1, val2, oper));
        }

        return val.peek();
    }
}

