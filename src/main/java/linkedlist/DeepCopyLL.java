package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class DeepCopyLL {
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node itr = head;
        Map<Node, Node> map = new HashMap<>();

        while (itr != null) {
            map.put(itr, new Node(itr.val));
            itr = itr.next;
        }

        itr = head;

        while (itr != null) {
            map.get(itr).next = map.get(itr.next);
            map.get(itr).random = map.get(itr.random);
            itr = itr.next;
        }

        return map.get(head);

    }
}
