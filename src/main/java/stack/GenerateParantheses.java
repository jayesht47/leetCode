package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParantheses {

    Stack<Character> mem = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(0, 0, n);
        return res;
    }

    public void backTrack(int openN, int closedN, int n) {
        if (openN == n && closedN == n) {
            StringBuilder sb = new StringBuilder();
            mem.forEach(sb::append);
            res.add(sb.toString());
        }
        if (openN < n) {
            mem.push('(');
            backTrack(openN + 1, closedN, n);
            mem.pop();
        }
        if (closedN < openN) {
            mem.push(')');
            backTrack(openN, closedN + 1, n);
            mem.pop();
        }
    }

}
