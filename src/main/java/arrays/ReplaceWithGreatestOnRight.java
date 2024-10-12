package arrays;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side
 */
public class ReplaceWithGreatestOnRight {
    public int[] replaceElements(int[] arr) {
        int greatestNumber = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = greatestNumber;
            greatestNumber = Math.max(greatestNumber, tmp);
        }
        return arr;
    }
}
