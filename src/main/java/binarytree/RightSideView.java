package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import stack.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            int currentQueueSize = queue.size();
            int counter = 0;
            TreeNode cur = null;
            while (counter < currentQueueSize) {
                cur = queue.remove();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                if (counter == currentQueueSize - 1) result.add(cur.val);
                counter++;
            }
        }
        return result;
    }
}
