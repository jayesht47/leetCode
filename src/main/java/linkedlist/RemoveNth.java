package linkedlist;

public class RemoveNth {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null)
            return null;

        ListNode itr = head;
        int len = 1;

        while (itr.next != null) {
            len++;
            itr = itr.next;
        }

        if (len == n)
            return head.next;

        int counter = len - n - 1;
        itr = head;
        while (counter > 0) {
            itr = itr.next;
            counter--;
        }

        itr.next = itr.next.next;

        return head;
    }
}
