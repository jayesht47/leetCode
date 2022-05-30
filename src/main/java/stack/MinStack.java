package stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class MinStack {

    private int minElem;
    private List<Integer> data;

    public MinStack() {
        data = new LinkedList<>();
        minElem = Integer.MAX_VALUE;
    }

    public void push(int val) {
        minElem = Math.min(val, minElem);
        data.add(val);
    }

    public void pop() {
        data.remove(data.size() - 1);
        minElem = Integer.MAX_VALUE;
        for (Integer datum : data) {
            minElem = datum < minElem ? datum : minElem;
        }
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return minElem;
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "minElem=" + minElem +
                ", data=" + data +
                '}';
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */