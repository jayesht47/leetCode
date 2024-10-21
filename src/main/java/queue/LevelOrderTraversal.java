package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import stack.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Basically BFS
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> oneLevel = new ArrayList<>();
            int counter = 0;
            int curQueueSize = queue.size();
            while (counter < curQueueSize) {
                TreeNode cur = queue.remove();
                oneLevel.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                counter++;
            }
            result.add(oneLevel);
        }
        return result;
    }
}
