// Jose Lopez
import java.util.Stack;

public class Program4 {

    public static String InfixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                postfix.append(ch);
            } else {
                if (ch != ' ') {
                    if (isOperator(ch)) {
                        while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                            postfix.append(" ").append(stack.pop());
                        }
                        stack.push(ch);
                    } else if (ch == '(') {
                        stack.push(ch);
                    } else if (ch == ')') {
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            postfix.append(" ").append(stack.pop());
                        }
                        stack.pop();
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(" ").append(stack.pop());
        }

        return postfix.toString();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0; // Default precedence for other characters
    }

    public static void main(String[] args) {
        String infixExpression = "4 + 6 * 3.1";
        String postfixExpression = InfixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}