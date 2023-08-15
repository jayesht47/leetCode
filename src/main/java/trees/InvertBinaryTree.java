package trees;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;
        if (node.left != null || node.right != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        if (node.left != null) invertTree(node.left);
        if (node.right != null) invertTree(node.right);
    }

}
