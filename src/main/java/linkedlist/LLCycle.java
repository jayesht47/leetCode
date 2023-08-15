package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LLCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> list = new HashSet<>();
        while (head != null) {
            if (list.contains(head))
                return true;
            list.add(head);
            head = head.next;
        }
        return false;
    }
}
