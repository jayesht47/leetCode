package twopointer;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water
 */
public class TrappingRainWater {

    /**
     * O(n) time and O(1) memory with 2 pointers
     *
     * @param height heights arr
     * @return
     */
    public int trap(int[] height) {
        int waterTrapped = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int leftMax = height[leftPointer];
        int rightMax = height[rightPointer];

        while (leftPointer < rightPointer) {
            if (leftMax < rightMax) {
                leftPointer++;
                leftMax = Math.max(leftMax, height[leftPointer]);
                waterTrapped += leftMax - height[leftPointer];
            } else {
                rightPointer--;
                rightMax = Math.max(rightMax, height[rightPointer]);
                waterTrapped += rightMax - height[rightPointer];
            }
        }
        return waterTrapped;
    }

    /**
     * O(n) Memory
     *
     * @param height height arr
     * @return trapped water
     */
    public int trapOld(int[] height) {

        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];
        int[] waterTrapped = new int[height.length];

        //getting leftMaxHeight
        int leftMax = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i - 1]);
            leftMaxHeight[i] = leftMax;
        }

        //getting rightMaxHeight
        int rightMax = 0;
        for (int i = height.length - 2; i > 0; i--) {
            rightMax = Math.max(rightMax, height[i + 1]);
            rightMaxHeight[i] = rightMax;
        }

        //getting waterTrapped with formula Min(MaxLeftHeightTill i , MaxRightHeightTill i) - currentHeight

        for (int i = 0; i < height.length; i++) {
            int oneWaterTrapped = Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
            waterTrapped[i] = Math.max(oneWaterTrapped, 0); //since we dont want to save negative values
        }

        return Arrays.stream(waterTrapped).sum();

    }


}
