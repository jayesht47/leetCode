package stack;

import java.util.List;

public class Node {
    int data;
    List<Node> neighbours;

    Node(int data, List<Node> neighbours) {
        this.data = data;
        this.neighbours = neighbours;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }
}
