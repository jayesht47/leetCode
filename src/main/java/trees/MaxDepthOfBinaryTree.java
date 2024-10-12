package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {

    public int maxDepthRecursive(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node != null && node.left != null) queue.add(node.left);
                if (node != null && node.right != null) queue.add(node.right);
            }
        }
        return level;
    }

}
