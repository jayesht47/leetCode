package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
 */
public class CloneGraphProb {

    static Node[] nodeArr = new Node[101];

    /**
     * @param n1 Node <b>from</b> which we have to copy
     * @param n2 Node <b>To</b> which we have to copy
     */
    private void CopyNode(Node n1, Node n2) {
        if (n1.neighbors == null) return;

        for (Node n : n1.neighbors) {
            if (nodeArr[n.val] != null) {
                Node temp = new Node(n.val);
                n2.neighbors.add(temp);
            }
        }
    }

    private void DFS(Node node, Node result, List<Node> visited) {
        ArrayList<Node> newNeighbors = new ArrayList<>();
        visited.add(node);
        for (Node n : node.neighbors) {
            if (visited.contains(n)) {
                if (nodeArr[n.val] == null) {
                    Node temp = new Node(n.val);
                    nodeArr[n.val] = temp;
                    newNeighbors.add(temp);
                } else {
                    newNeighbors.add(nodeArr[n.val]);
                }
            } else if (n.neighbors == null) {
                if (nodeArr[n.val] == null) {
                    Node temp = new Node(n.val);
                    nodeArr[n.val] = temp;
                    newNeighbors.add(temp);
                } else {
                    newNeighbors.add(nodeArr[n.val]);
                }
            } else {
                Node temp = new Node(n.val);
                nodeArr[n.val] = temp;
                newNeighbors.add(temp);
                DFS(n, temp, visited);
            }
        }
        result.neighbors = newNeighbors;
    }

    public Node cloneGraph(Node node) {

        ArrayList<Node> visited = new ArrayList<>();
        if (node == null) return null;
        Node result = new Node(node.val, (ArrayList<Node>) node.neighbors);
        nodeArr[1] =result;
        if (result.neighbors == null)
            return result;
        DFS(node, result, visited);
        return result;
    }
}
