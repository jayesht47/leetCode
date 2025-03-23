package heap;

import java.util.*;

/**
 * https://neetcode.io/solutions/task-scheduler
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char c : tasks) taskCount[c - 'A'] += 1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer[]> queue = new LinkedList<>();
        Arrays.stream(taskCount).forEach(e -> {
            if (e > 0) maxHeap.add(e);
        });
        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time += 1;
            if (!queue.isEmpty() && queue.peek()[1] == time) maxHeap.add(queue.poll()[0]);
            if (maxHeap.isEmpty()) continue;
            int count = maxHeap.poll();
            if (count > 1) queue.add(new Integer[]{count - 1, time + n + 1});
        }
        return time;
    }

}
