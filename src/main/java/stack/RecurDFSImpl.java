package stack;

import java.util.Set;

public class RecurDFSImpl {

    public boolean DFS(Node target, Set<Node> visited, Node currentNode) {
        if (currentNode.val == target.val) return true;
        else if (currentNode.neighbors != null) {
            for (Node node : currentNode.neighbors) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    if (DFS(target, visited, node)) return true;
                }
            }
        }
        return false;
    }

}
