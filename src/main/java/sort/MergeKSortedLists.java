package sort;

import linkedlist.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHead = null;
        ListNode curResultNode = null;
        while (!toStop(lists)) {
            int minIndex = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < minValue) {
                        minValue = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            if (resultHead == null) {
                resultHead = new ListNode(minValue);
                curResultNode = resultHead;
            } else {
                ListNode listNode = new ListNode(minValue);
                curResultNode.next = listNode;
                curResultNode = listNode;
            }
            lists[minIndex] = lists[minIndex].next;
        }
        return resultHead;
    }

    private boolean toStop(ListNode[] lists) {
        for (ListNode n : lists) {
            if (n != null) return false;
        }
        return true;
    }
}
