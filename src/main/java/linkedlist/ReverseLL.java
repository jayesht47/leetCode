package linkedlist;


/**
 * https://leetcode.com/problems/reverse-linked-list
 * Solution using recursion
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
        ListNode res = rev(head, null);
        return res;
    }

    private static ListNode rev(ListNode node, ListNode prev) {
        if (node == null) return prev;
        ListNode next = node.next;
        node.next = prev;
        prev = node;
        node = next;
        return rev(node, prev);
    }

}