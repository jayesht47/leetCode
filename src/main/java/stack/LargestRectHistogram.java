package stack;

import java.util.AbstractMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectHistogram {
    public int largestRectangleArea(int[] heights) {

        Stack<AbstractMap.Entry<Integer, Integer>> mem = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            if (!mem.isEmpty()) {
                if (heights[i] < mem.peek().getValue()) //current height is less than top of stack, so we pop
                {
                    int oldIndex = 0;
                    int oldHeight = 0;
                    while (!mem.isEmpty() && heights[i] < mem.peek().getValue()) {
                        oldIndex = mem.peek().getKey();
                        oldHeight = mem.peek().getValue();
                        int area = (i - oldIndex) * oldHeight;
                        maxArea = Math.max(maxArea, area);
                        mem.pop();
                    }
                    mem.add(new AbstractMap.SimpleEntry<>(oldIndex, heights[i]));
                } else
                    mem.add(new AbstractMap.SimpleEntry<>(i, heights[i])); //adding oldIndex as start index if height of current is
            } else
                mem.add(new AbstractMap.SimpleEntry<>(i, heights[i]));
        }

        while (!mem.isEmpty()) {
            int area = (heights.length - mem.peek().getKey()) * mem.peek().getValue();
            maxArea = Math.max(maxArea, area);
            mem.pop();
        }

        return maxArea;

    }
}
