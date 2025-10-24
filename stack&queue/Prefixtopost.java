import java.util.Stack;
public class Prefixtopost {
   
        public static void main(String[] args) {
            String prefix = "*-A/BC-/AKL";
            System.out.println("Prefix:  " + prefix);
            System.out.println("Postfix: " + prefixToPostfix(prefix));
        }
    
        public static String prefixToPostfix(String prefix) {
            Stack<String> stack = new Stack<>();
    
            // Scan right to left
            for (int i = prefix.length() - 1; i >= 0; i--) {
                char ch = prefix.charAt(i);
    
                // If operand, push as string
                if (Character.isLetterOrDigit(ch)) {
                    stack.push(ch + "");
                } 
                // If operator
                else {
                    String op1 = stack.pop();
                    String op2 = stack.pop();
    
                    // create postfix: operand1 operand2 operator
                    String temp = op1 + op2 + ch;
                    stack.push(temp);
                }
            }
    
            // Final postfix expression
            return stack.peek();
        }
    }
    


