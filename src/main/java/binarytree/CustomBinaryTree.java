package binarytree;

import java.util.Stack;

public class CustomBinaryTree {

    public Node root;

    public CustomBinaryTree() {
        root = null;
    }

    public CustomBinaryTree(int data) {
        root = new Node(data);
    }

    public void addNode(int data) {

        if (root == null) {
            root = new Node(data);
        } else {

            Node itrNode = root;

            while (true) {
                if (data < itrNode.data) {
                    if (itrNode.left == null) {
                        itrNode.left = new Node(data);
                        return;
                    }
                    itrNode = itrNode.left;
                } else {
                    if (itrNode.right == null) {
                        itrNode.right = new Node(data);
                        return;
                    }
                    itrNode = itrNode.right;
                }
            }
        }
    }

    public static void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            if (node.left != null)
                preOrderTraversal(node.left);
            if (node.right != null)
                preOrderTraversal(node.right);
        }
    }

    public static void levelTraversal(Node node) {
        Stack<Node> curLevel = new Stack<>();
        curLevel.push(node);
        Node curNode = node;

        while (curNode != null) {
            curNode = curLevel.pop();
            if (curNode.right != null)
                curLevel.push(curNode.right);
            if (curNode.left != null)
                curLevel.push(curNode.left);
        }

    }

}
