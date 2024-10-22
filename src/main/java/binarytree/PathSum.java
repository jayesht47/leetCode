package binarytree;

import stack.TreeNode;

/**
 * https://leetcode.com/problems/path-sum
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPath(root, targetSum);
    }

    private boolean hasPath(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null)
            return targetSum == root.val;
        if (hasPath(root.left, targetSum - root.val)) return true;
        if (hasPath(root.right, targetSum - root.val)) return true;
        return false;
    }
}
