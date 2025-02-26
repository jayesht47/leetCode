package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(stones).forEach(heap::add);
        while (heap.size() > 1){
            int max = heap.poll();
            int secondHighest = heap.poll();
            heap.add(max - secondHighest);
        }
        return heap.peek();
    }
}
