package linkedlist;

import java.util.Stack;

/**
 *https://leetcode.com/problems/reverse-linked-list
 * Solution using stack and O(2n) time O(n) space
 */
public class ReverseLL {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> mem = new Stack<>();
        ListNode next = head;
        while (next != null) {
            mem.push(next);
            next = next.next;
        }
        ListNode node;
        ListNode res = mem.peek();
        while (!mem.isEmpty()) {
            node = mem.pop();
            node.next = mem.size() > 0 ? mem.peek() : null;
        }
        return res;
    }

}