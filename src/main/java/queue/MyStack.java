package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue2 = new LinkedList<>();
        queue2.add(x);
        for (int e : queue1) queue2.add(e);
        queue1 = new LinkedList<>();
        for (int e : queue2) queue1.add(e);
    }

    public int pop() {
        queue1.remove();
        return queue2.remove();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
}