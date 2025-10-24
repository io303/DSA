import java.util.Stack;
public class Poste {
   
        public static void main(String[] args) {
            String exp = "953+4*6/-"; // (9 - ((5 + 3) * 4) / 6)
            System.out.println("Postfix Expression: " + exp);
            System.out.println("Result: " + evaluatePostfix(exp));
        }
    
        public static int evaluatePostfix(String s) {
            Stack<Integer> stack = new Stack<>();
    
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
    
                // operand
                if (Character.isDigit(ch)) {
                    stack.push(ch - '0');  // convert char → int
                } 
                // operator
                else {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    int res = 0;
    
                    switch (ch) {
                        case '+': res = val1 + val2; break;
                        case '-': res = val1 - val2; break;
                        case '*': res = val1 * val2; break;
                        case '/': res = val1 / val2; break;
                        case '^': res = (int)Math.pow(val1, val2); break;
                    }
                    stack.push(res);
                }
            }
    
            return stack.peek();
        }
    }
    


