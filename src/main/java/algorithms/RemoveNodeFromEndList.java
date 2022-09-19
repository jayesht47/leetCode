package algorithms;

import algoDep.ListNode;

public class RemoveNodeFromEndList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode nodeToModify = head;
        ListNode node = head;
        while (true) {
            int counter = 0;
            while (counter < n) {
                node = node.next;
                counter++;
            }
            if (node.next == null) {
                if (null == nodeToModify.next.next)
                    nodeToModify.next = null;
                else
                    nodeToModify.next = nodeToModify.next.next;
                return head;
            } else
                nodeToModify = node;
        }
    }

}
