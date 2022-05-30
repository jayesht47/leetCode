package stack;

import java.util.LinkedList;
import java.util.List;

class MinStack {

    private static class Node {
        int value;
        int minElement = Integer.MAX_VALUE;
        static int globalMin = Integer.MAX_VALUE;

        public String toString() {
            return "Node{" +
                    "data :: " + value + "" +
                    " minElement :: " + minElement + "}";
        }

        private void setMin(int data) {
            if (globalMin == Integer.MAX_VALUE) {
                globalMin = data;
            } else {
                globalMin = Math.min(data, globalMin);
            }

        }

        Node(int value) {
            this.value = value;
            this.minElement = Math.min(this.minElement, value);
            setMin(value);
            this.minElement = Math.min(globalMin, this.minElement);
        }


    }

    private int minElem;
    private List<Node> data;

    public MinStack() {
        data = new LinkedList<>();
        minElem = Integer.MAX_VALUE;
        Node.globalMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        minElem = Math.min(val, minElem);
        Node temp = new Node(val);
        data.add(temp);
    }

    public void pop() {

        boolean lastLargestRemoved = false;

        if (!data.isEmpty() && (data.get(data.size() - 1) != null) && (data.get(data.size() - 1).value) == Node.globalMin) {
            lastLargestRemoved = true;
        }
        data.remove(data.size() - 1);
        if (lastLargestRemoved && !data.isEmpty() && (data.get(data.size() - 1) != null))
            Node.globalMin = data.get(data.size() - 1).minElement;
        if (data.size() == 0) Node.globalMin = Integer.MAX_VALUE;
        minElem = Integer.MAX_VALUE;
    }

    public int top() {
        return data.get(data.size() - 1).value;
    }

    public int getMin() {
        return data.get(data.size() - 1).minElement;
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