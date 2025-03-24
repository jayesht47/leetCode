package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestInArr {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Arrays.stream(nums).forEach(heap::add);
        int counter = nums.length - k;
        while (counter > 0) {
            heap.poll();
            counter--;
        }
        return heap.peek();
    }
}
