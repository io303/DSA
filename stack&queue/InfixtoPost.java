
import java.util.Stack;
public class InfixtoPost {
   
    

        public static void main(String[] args) {
            String exp = "(A-B/C)*(A/K-L)";
            System.out.println("Infix:   " + exp);
            System.out.println("Postfix: " + infixToPostfix(exp));
        }
    
        static int precedence(char ch) {
            if (ch == '+' || ch == '-') return 1;
            else if (ch == '*' || ch == '/') return 2;
            else if (ch == '^') return 3;
            return -1;
        }
    
        public static String infixToPostfix(String s) {
            Stack<String> operand = new Stack<>();
            Stack<Character> operator = new Stack<>();
    
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
    
                // operand
                if (Character.isLetterOrDigit(ch)) {
                    operand.push(ch + "");
                }
    
                // left bracket
                else if (ch == '(') {
                    operator.push(ch);
                }
    
                // right bracket
                else if (ch == ')') {
                    while (!operator.isEmpty() && operator.peek() != '(') {
                        char op = operator.pop();
                        String v2 = operand.pop();
                        String v1 = operand.pop();
                        String post = v1 + v2 + op;
                        operand.push(post);
                    }
                    operator.pop(); // remove '('
                }
    
                // operator
                else {
                    while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)) {
                        if (operator.peek() == '(') break;
                        char op = operator.pop();
                        String v2 = operand.pop();
                        String v1 = operand.pop();
                        String post = v1 + v2 + op;
                        operand.push(post);
                    }
                    operator.push(ch);
                }
            }
    
            // pop remaining operators
            while (!operator.isEmpty()) {
                char op = operator.pop();
                String v2 = operand.pop();
                String v1 = operand.pop();
                String post = v1 + v2 + op;
                operand.push(post);
            }
    
            return operand.peek();
        }
    }
    


