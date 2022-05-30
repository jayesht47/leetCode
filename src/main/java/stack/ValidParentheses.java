package stack;

import java.util.Stack;

public class ValidParentheses {

    private boolean isOpeningBrace(char c) {
        return (c == '(' || c == '{' || c == '[');
    }

    private boolean isSameOpenBrace(char openingBrace, char closingBrace) {
        if (openingBrace == '(') return closingBrace == ')';
        if (openingBrace == '{') return closingBrace == '}';
        if (openingBrace == '[') return closingBrace == ']';
        return false;
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {

            if (isOpeningBrace(c)) {
                stack.push(c);
            } else {

                if (stack.size() > 0 && isSameOpenBrace(stack.peek(), c)) {
                    stack.pop();
                } else
                    return false;
            }
        }
        return stack.size() == 0;
    }
}
