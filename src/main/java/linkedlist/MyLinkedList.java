package linkedlist;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/**
 * https://leetcode.com/problems/design-linked-list
 */
public class MyLinkedList {

    class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
            prev = null;
        }
    }

    ListNode head = null;

    ListNode tail = null;

    int length = 0;

    public MyLinkedList() {
    }

    public int get(int index) {
        ListNode counterNode = head;
        if (index >= 0 && index < length) {
            int counter = 0;
            while (counter < index) {
                counterNode = counterNode.next;
                counter++;
            }
            return counterNode.val;
        } else return -1;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            if (tail == null) tail = head;
        } else {
            ListNode newHead = new ListNode(val);
            newHead.next = head; //not setting prev as default is null
            head.prev = newHead;
            head = newHead; //updating reference to head
        }
        this.length++;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            if (head == null) head = tail;
        } else {
            ListNode newTail = new ListNode(val);
            newTail.prev = tail; //not setting next as default is null
            tail.next = newTail;
            tail = newTail; //updating reference to tail
        }
        this.length++;
    }

    public void addAtIndex(int index, int val) {
        boolean toIncrement = false;
        if (index > 0 && index < length) {
            ListNode newNode = new ListNode(val);
            int counter = 0;
            ListNode counterNode = head;
            while (counter < index - 1) {
                counterNode = counterNode.next;
                counter++;
            }
            newNode.next = counterNode.next;
            newNode.prev = counterNode;
            counterNode.next.prev = newNode;
            counterNode.next = newNode;
            toIncrement = true;
        }
        if (index == length) {
            addAtTail(val);
            toIncrement = false;
        }
        if (index == 0) {
            addAtHead(val);
            toIncrement = false;
        }
        if (toIncrement) this.length++;
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < length) {
            int counter = 0;
            ListNode counterNode = head;
            while (counter < index) {
                counterNode = counterNode.next;
                counter++;
            }
            if (counterNode.next != null) {
                counterNode.next.prev = counterNode.prev;
            } else tail = tail.prev; //meaning we are deleting tail element
            if (counterNode.prev != null) {
                counterNode.prev.next = counterNode.next;
            } else head = head.next; //meaning we are deleting head element
            this.length--;
        }
    }
}

