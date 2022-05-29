package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

    private static boolean isPerfectSquare(int input) {
        int sqrt = (int) Math.sqrt(input);
        return input == sqrt * sqrt;
    }

    public static int numSquares(int input) {

        if (input == 1) return 1;
        if (isPerfectSquare(input)) return 1;

        Queue<Integer> perfectSquares = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= input; i++) {
            if (isPerfectSquare(i))
                perfectSquares.add(i);
        }
        queue.add(0);
        int perfectSqCount = 0;

        while (!queue.isEmpty()) {
            perfectSqCount++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {

                int curElement = queue.poll();

                for (int perfSq : perfectSquares) {
                    int currentSum = curElement + perfSq;

                    if (currentSum == input) {
                        return perfectSqCount;
                    } else if ((currentSum < input) && !visited.contains(currentSum)) {
                        queue.add(currentSum);
                        visited.add(currentSum);
                    } else if (currentSum > input) {
                        break;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

}
