package stack;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
 */

public class EvalRPN {

    private boolean isOperator(String input) {
        if (input.equals("+") || input.equals("*") || input.equals("/") || input.equals("-"))
            return true;

        return false;
    }

    private String operate(String operand1, String operand2, String operator) {
        String result = "";
        switch (operator) {
            case "+": {
                int op1 = Integer.parseInt(operand1);
                int op2 = Integer.parseInt(operand2);
                result = Integer.toString(op1 + op2);
                break;
            }
            case "-": {
                int op1 = Integer.parseInt(operand1);
                int op2 = Integer.parseInt(operand2);
                result = Integer.toString(op1 - op2);
                break;
            }
            case "*": {
                int op1 = Integer.parseInt(operand1);
                int op2 = Integer.parseInt(operand2);
                result = Integer.toString(op1 * op2);
                break;
            }
            case "/": {
                int op1 = Integer.parseInt(operand1);
                int op2 = Integer.parseInt(operand2);
                result = Integer.toString(op1 / op2);
                break;
            }
            default: {
                throw new IllegalArgumentException("Illegal operator");
            }
        }
        return result;
    }

    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for (String a : tokens) {
            if (!isOperator(a)) {
                stack.push(a);
            } else {
                String operator2 = stack.pop();
                String operator1 = stack.pop();
                String result = operate(operator1, operator2, a);
                stack.push(result);
            }
        }
        return Integer.parseInt(stack.pop());

    }
}
