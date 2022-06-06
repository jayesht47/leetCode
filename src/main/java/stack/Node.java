package stack;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    Node(int data, List<Node> neighbours) {
        this.val = data;
        this.neighbors = neighbours;
    }


    public int getData() {
        return val;
    }

    public void setData(int data) {
        this.val = data;
    }

    public List<Node> getNeighbours() {
        return neighbors;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbors = neighbours;
    }
}
