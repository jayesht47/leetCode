package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderLL {

    public void reorderList(ListNode head) {

        //Getting midNode using 2 pointer approach
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        ListNode secondHead = slowNode.next;
        ListNode prev = slowNode.next =null;

        //Reversing second half of the list
        while (secondHead != null) {
            ListNode temp = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = temp;
        }
        //Reordering according to pattern
        secondHead = prev;
        ListNode firstHead = head;
        while (secondHead != null) {
            ListNode first = firstHead.next;
            ListNode second = secondHead.next;
            firstHead.next = secondHead;
            secondHead.next = first;
            firstHead = first;
            secondHead = second;
        }
    }

}