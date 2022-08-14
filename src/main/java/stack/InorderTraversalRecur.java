package stack;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalRecur {
    private void inOrderTraverse(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            inOrderTraverse(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            inOrderTraverse(node.right, result);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        inOrderTraverse(root, result);

        return result;
    }
}