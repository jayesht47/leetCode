package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
 */
public class CloneGraphProb {

    private void DFS(Node node, Node result, List<Node> visited) {
        ArrayList<Node> newNeighbors = new ArrayList<>();
        visited.add(node);
        for (Node n : node.neighbors) {
            if (visited.contains(n))
                newNeighbors.add(n);
            else if (n.neighbors == null)
                newNeighbors.add(n);
            else {
                Node newNode = new Node(n.val);
                newNeighbors.add(newNode);
                DFS(n, newNode, visited);
            }
        }
        result.neighbors = newNeighbors;
    }

    public Node cloneGraph(Node node) {

        ArrayList<Node> visited = new ArrayList<>();

        if (node == null) return null;

        Node result = new Node(node.val);

        if (result.neighbors == null)
            return result;

        DFS(node, result, visited);

        return result;
    }
}
