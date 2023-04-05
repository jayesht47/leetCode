package linkedlist;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeSortedLL {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalRes = null;
        ListNode res = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (res == null) {
                    res = list1;
                    finalRes = list1;
                } else {
                    res.next = list1;
                    res = res.next;
                }
                list1 = list1.next;
            } else {
                if (res == null) {
                    res = list2;
                    finalRes = list2;
                } else {
                    res.next = list2;
                    res = res.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 == null) {
//Appending all list 2 elements
            while (list2 != null) {
                if (res == null) {
                    res = list2;
                    finalRes = res;
                } else {
                    res.next = list2;
                    res = res.next;
                }

                list2 = list2.next;
            }
        } else if (list2 == null) {
            while (list1 != null) {
                if (res == null) {
                    res = list1;
                    finalRes = res;
                } else {
                    res.next = list1;
                    res = res.next;
                }
                list1 = list1.next;
            }
        }

        return finalRes;

    }

}