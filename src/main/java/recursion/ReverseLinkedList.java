package recursion;

import linkedlist.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return swapList(head, null);
    }

    private ListNode swapList(ListNode node, ListNode prev) {
        if (node == null) return prev;
        else {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            return swapList(next,prev);
        }
    }
}
