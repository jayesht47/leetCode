package algoDep;

public class ListNode {
    int val;
    public ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListFromArr(int[] arr) {
        ListNode[] nodeArr = new ListNode[arr.length];
        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = new ListNode(arr[i]);
        }
        for (int i = 0; i < nodeArr.length - 1; i++) {
            nodeArr[i].next = nodeArr[i + 1];
        }
        return nodeArr[0];
    }

    @Override
    public String toString() {
        return "val is " + this.val;
    }

    public static void printList(ListNode node) {
        if (node == null)
            throw new IllegalArgumentException("Received node as Null");
        System.out.print("[");
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print(node.val + "]");
    }
}
