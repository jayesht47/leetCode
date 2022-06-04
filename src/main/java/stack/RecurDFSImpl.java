package stack;

import java.util.Set;

public class RecurDFSImpl {

    public boolean DFS(Node target, Set<Node> visited, Node currentNode) {
        if (currentNode.data == target.data) return true;
        else if (currentNode.neighbours != null) {
            for (Node node : currentNode.neighbours) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    if (DFS(target, visited, node)) return true;
                }
            }
        }
        return false;
    }

}
