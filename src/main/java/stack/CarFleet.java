package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/car-fleet/
 */
public class CarFleet {

    /**
     * O(nlogn) solution for CarFleet
     * @param target target
     * @param position position arr
     * @param speed speed arr
     * @return number of car fleets
     */
    public int carFleet(int target, int[] position, int[] speed) {

        if (position.length == 1) return 1;

        int[][] combinedArr = new int[position.length][2];
        Stack<Double> timeStack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            combinedArr[i][0] = position[i];
            combinedArr[i][1] = speed[i];
        }

        Arrays.sort(combinedArr, java.util.Comparator.comparingInt(o -> o[0]));

        for (int i = position.length - 1; i >= 0; i--) {
            if (!timeStack.isEmpty()) {
                Double curTime = ((double) target - combinedArr[i][0]) / combinedArr[i][1];
                if (curTime > timeStack.peek())
                    timeStack.add(curTime);
            } else
                timeStack.add(((double) target - combinedArr[i][0]) / combinedArr[i][1]);
        }
        return timeStack.size();
    }

}
