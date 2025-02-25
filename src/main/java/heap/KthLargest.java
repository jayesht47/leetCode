package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();

    private int heapSize = 0;


    public KthLargest(int k, int[] nums) {
        heapSize = k;
        Arrays.stream(nums).forEach(heap::add);
        int counter = k;
        while (counter < nums.length) {
            heap.poll();
            counter++;
        }
    }

    public int add(int val) {
        heap.add(val);
        int counter = heapSize;
        while(heap.size() > counter) {
            heap.poll();
        }
        return heap.peek();
    }
}
