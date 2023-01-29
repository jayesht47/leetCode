package stack;

/**
 * Two stack with single arr with 2 pointers approach
 * uri :: https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 */
public class TwoStack {

    private Integer top1;
    private Integer top2;
    private int[] arr;

    public TwoStack() {
        top1 = 0;
        top2 = 1;
        arr = new int[4];
    }

    private void expandArr() {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    public boolean push1(int input) {
        if (top1 != null && top1 < arr.length - 2) {
            top1 += 2;
            arr[top1] = input;
            return true;
        } else {
            if (top1 != null && top1 != arr.length - 2) {
                return false;
            }
            expandArr();
            top1 += 2;
            arr[top1] = input;

        }
        return false;
    }

    public int pop1() {
        if (top1 != null && top1 > 0) {
            int e = arr[top1];
            arr[top1] = 0;
            top1 -= 2;
            return e;
        }
        if (top1 == null) {
            throw new IllegalStateException("TwoStack not initialized");
        }
        if (top1 == 0) {
            throw new IllegalStateException("Stack  1 underflow");
        }
        return -1;
    }

    public boolean push2(int input) {
        if (top2 != null && top2 < arr.length - 2) {
            top2 += 2;
            arr[top2] = input;
            return true;
        } else if (top2 != null && top2 == arr.length - 2) {
            expandArr();
            top2 += 2;
            arr[top2] = input;
        } else if (top2 == null) {
            throw new IllegalStateException("TwoStack not initialized");
        }
        return false;
    }

    public int pop2() {
        if (top2 != null && top2 > 1) {
            int e = arr[top2];
            arr[top2] = 0;
            top2 -= 2;
            return e;
        }
        if (top2 == null) {
            throw new IllegalStateException("TwoStack not initialized");
        }
        if (top2 == 1) {
            throw new IllegalStateException("Stack 2 underflow");
        }
        return -1;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        for (int j : arr) {
            if (j != 0) {
                sb.append("'");
                sb.append(j);
                sb.append("',");
            }

        }
        if (sb.charAt(sb.length() - 1) == ',')
            sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
