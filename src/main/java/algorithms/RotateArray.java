package algorithms;


/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newPosition = i + k >= nums.length ? i + k - nums.length : i + k;
            //Swapping current and newPosition
//            nums[i] += nums[newPosition];
//            nums[newPosition] = nums[i];
//            nums[i] -= nums[newPosition];
            resultArr[newPosition] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = resultArr[i];
        }
    }

}
