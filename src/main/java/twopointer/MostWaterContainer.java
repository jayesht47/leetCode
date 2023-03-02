package twopointer;

/**
 * https://leetcode.com/problems/container-with-most-water
 */
public class MostWaterContainer {

    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;

        while (leftPointer < rightPointer) {
            int area = (((rightPointer + 1) - (leftPointer + 1)) * Math.min(height[leftPointer], height[rightPointer]));
            maxArea = Math.max(area, maxArea);
            if (height[leftPointer] < height[rightPointer])
                leftPointer++;
            else
                rightPointer--;
        }
        return maxArea;
    }

}
