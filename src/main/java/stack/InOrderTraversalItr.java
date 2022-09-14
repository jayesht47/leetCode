package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalItr {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        nodeStack.push(root);

        TreeNode curNode = root;

        while (curNode != null) {
            curNode = nodeStack.pop();
            if (curNode != null && curNode.left != null) {
                nodeStack.push(curNode.left);
            }
            if (curNode != null)
                result.add(curNode.val);
            if (curNode != null && curNode.right != null) {
                nodeStack.push(curNode.left);
            }
        }
        return result;
    }

}
