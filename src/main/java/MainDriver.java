import algoDep.ListNode;
import algorithms.*;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {
        int[] inputNums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createListFromArr(inputNums);
        ListNode.printList(head);
        System.out.println();
        RemoveNodeFromEndList m = new RemoveNodeFromEndList();
        ListNode.printList((m.removeNthFromEnd(head, 2)));
    }
}
