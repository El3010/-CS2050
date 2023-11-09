import java.util.Stack;

public class Program3 {
    public static String InfixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Define the precedence of operators
        // Higher value means higher precedence
        // You can add more operators as needed
        int precedence = 0;
        int precedencePlusMinus = 1;
        int precedenceMultiplyDivide = 2;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                // If the character is a digit or '.', append it to the postfix expression
                postfix.append(c);
            } else if (c == ' ') {
                // Ignore spaces
                continue;
            } else if (isOperator(c)) {
                // If the character is an operator, handle it
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(" ").append(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                // If the character is an opening parenthesis, push it onto the stack
                stack.push(c);
            } else if (c == ')') {
                // If the character is a closing parenthesis, pop and append operators until an opening parenthesis is encountered
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(" ").append(stack.pop());
                }
                stack.pop(); // Pop the opening parenthesis
            }
        }

        // Pop and append any remaining operators from the stack to the postfix expression
        while (!stack.isEmpty()) {
            postfix.append(" ").append(stack.pop());
        }

        return postfix.toString();
    }

    // Helper method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Helper method to determine the precedence of operators
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return precedencePlusMinus;
            case '*':
            case '/':
                return precedenceMultiplyDivide;
            default:
                return precedence;
        }
    }

    public static void main(String[] args) {
        String infixExpression = "4 + 6 * 3.1";
        String postfixExpression = InfixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
