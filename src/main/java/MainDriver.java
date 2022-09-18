import algoDep.ListNode;
import algorithms.*;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {
        int[] inputNums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createListFromArr(inputNums);
        MiddleOfLinkedList m = new MiddleOfLinkedList();
        System.out.println(m.middleNode(head));
    }
}
