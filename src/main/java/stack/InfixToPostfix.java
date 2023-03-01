package stack;

import java.util.Stack;

public class InfixToPostfix {

    private int checkPrec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private boolean isOp(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '(':
            case ')':
                return true;
        }
        return false;
    }

    public String converToPostFix(String input) {
        Stack<Character> opStack = new Stack<>();

        char[] inputCharArr = input.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : inputCharArr) {
            if (c == ' ')
                continue;
            if (!opStack.isEmpty() && !isOp(c))
                sb.append(c);
            if (opStack.isEmpty() && isOp(c)) {
                opStack.push(c);
            } else if (opStack.isEmpty() && !isOp(c)) {
                sb.append(c);
            } else if (!opStack.isEmpty() && isOp(c)) {
                if (c == '(')
                {
                    opStack.push(c);
                    continue;
                }
                if (c == ')') {
                    while (!opStack.isEmpty() && opStack.peek() != '(') {
                        sb.append(opStack.pop());
                    }
                    opStack.pop();
                    continue;
                }
                if (checkPrec(c) > checkPrec(opStack.peek())) {
                    opStack.push(c);
                } else {
                    while (!opStack.isEmpty() && checkPrec(opStack.peek()) >= checkPrec(c)) {
                        sb.append(opStack.pop());
                    }
                    opStack.push(c);
                }
            }
        }
        // pop all the operators from the stack
        while (!opStack.isEmpty()) {
            if (opStack.peek() == '(')
                return "Invalid Expression";
            sb.append(opStack.pop());
        }

        return sb.toString();

    }

}
