package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderLL {

    public void reorderList(ListNode head) {

        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        System.out.println("test1");

        ListNode secondHead = slowNode.next;
        ListNode prev = slowNode.next;

        //Reversing second half of the list
        while (secondHead != null) {
            ListNode temp = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = temp;
        }
        System.out.println("test1");

    }

}
