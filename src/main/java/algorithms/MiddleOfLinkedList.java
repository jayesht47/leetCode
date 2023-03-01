package algorithms;

import algoDep.ListNode;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode c1 = head;
        ListNode c2 = head;
        while (true) {
            if (c2.next == null)
                return c1;
            if (c2.next.next == null)
                return c1.next;
            c1 = c1.next;
            c2 = c2.next.next;
        }
    }

}
