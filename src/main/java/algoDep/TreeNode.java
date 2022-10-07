package algoDep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generateBinaryTreeFromArr(Integer[] input)
    {
        TreeNode root = new TreeNode();
        Queue<Integer> queue = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);
        TreeNode curNode = nodeStack.pop();
        Arrays.stream(input).forEach(queue::add);
        while (queue.size() > 0)
        {
            Integer curValue = queue.remove();
            if (curNode.left != null && curNode.right != null)
                curNode = nodeStack.pop();
            else if(curNode.left == null)
            {
                TreeNode leftNode = new TreeNode();
                leftNode.val = curValue;
                curNode.left = leftNode;
                nodeStack.add(leftNode);
            }
            else
            {
                TreeNode rightNode = new TreeNode();
                rightNode.val = curValue;
                curNode.right = rightNode;
                nodeStack.add(rightNode);
            }
        }
        return root;
    }
}
