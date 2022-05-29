package queue;

import java.util.*;

public class OpenTheLock {


    public static int openLock(String[] deadends, String target) {
        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        queue.add(start);
        int steps = -1;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                StringBuilder current = new StringBuilder(queue.poll());
                if (current.toString().equals(target)) return steps;
                if (visited.contains(current.toString())) continue;
                visited.add(current.toString());
                for (int i = 0; i < current.length(); i++) {
                    queue.add(current.substring(0, i) + ((current.charAt(i) == '9') ? 0 : (current.charAt(i) - '0' + 1)) + current.substring(i + 1));
                    queue.add(current.substring(0, i) + ((current.charAt(i) == '0') ? 9 : (current.charAt(i) - '0' - 1)) + current.substring(i + 1));
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        String[] deadends = {"8888"};
        String target = "0009";
        long start = System.currentTimeMillis();
        System.out.println(openLock(deadends, target));
        System.out.println("TTE :: " + (System.currentTimeMillis() - start));
    }
}
