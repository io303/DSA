import java.util.Stack;
public class Prefixe {
   
        public static void main(String[] args) {
            String exp = "-9/*+5346";  // equivalent to 9 - ((5 + 3) * 4 / 6)
            System.out.println("Prefix Expression: " + exp);
            System.out.println("Result: " + evaluatePrefix(exp));
        }
    
        public static int evaluatePrefix(String s) {
            Stack<Integer> stack = new Stack<>();
    
            for (int i = s.length() - 1; i >= 0; i--) {
                char ch = s.charAt(i);
    
                // operand
                if (Character.isDigit(ch)) {
                    stack.push(ch - '0');
                }
    
                // operator
                else {
                    int a = stack.pop();  // first popped = left operand
                    int b = stack.pop();  // second popped = right operand
                    int res = 0;
    
                    switch (ch) {
                        case '+': res = a + b; break;
                        case '-': res = a - b; break;
                        case '*': res = a * b; break;
                        case '/': res = a / b; break;
                        case '^': res = (int)Math.pow(a, b); break;
                    }
                    stack.push(res);
                }
            }
    
            return stack.peek();
        }
    }
    


