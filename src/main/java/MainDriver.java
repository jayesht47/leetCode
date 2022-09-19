import algoDep.ListNode;
import algorithms.*;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {
        int[] inputNums = {1,2};
        ListNode head = ListNode.createListFromArr(inputNums);
        RemoveNodeFromEndList m = new RemoveNodeFromEndList();
        System.out.println(m.removeNthFromEnd(head,2));
    }
}
