package algoDep;

public class ListNode {
    int val;
    public ListNode next;

    ListNode() {
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
}
