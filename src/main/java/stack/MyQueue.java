package stack;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Integer firstElement;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        firstElement = null;
    }

    public void push(int x) {
        stack1.push(x);
        if (!stack1.isEmpty()) {
            for (int i = 0; i < stack1.size(); i++) {
                stack2.push(stack1.get(i));
            }
        }
    }

    public int pop() {
        if (!stack1.isEmpty()) {
            for (int i = 0; i < stack1.size(); i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

