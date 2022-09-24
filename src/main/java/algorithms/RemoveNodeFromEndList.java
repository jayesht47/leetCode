package algorithms;

import algoDep.ListNode;

public class RemoveNodeFromEndList {

    public ListNode removeNthFromEndInit(ListNode head, int n) {
        int counter = 0;
        ListNode c = head;
        while (c.next != null) {
            counter++;
            c = c.next;
        }
        int counter2 = 0;
        ListNode c2 = head;
        if ((counter - n) < 0)
            return head.next;
        while (counter2 < counter - n) {
            c2 = c2.next;
            counter2++;
        }
        if (c2.next.next != null)
            c2.next = c2.next.next;
        else
            c2.next = null;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowerNode = head;
        ListNode fasterNode = head;
        //moving faster node n+1 steps ahead
        int c = 0;
        while (c < n) {
            c++;
            fasterNode = fasterNode.next;
        }
        if (fasterNode == null)
            return head.next;
        while (fasterNode.next != null) {
            fasterNode = fasterNode.next;
            slowerNode = slowerNode.next;
        }
        slowerNode.next = slowerNode.next.next;
        return head;
    }

}
