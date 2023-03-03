package twopointer;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/trapping-rain-water
 */
public class TrappingRainWater {

    public int trap(int[] height) {

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
