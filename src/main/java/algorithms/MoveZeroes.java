package algorithms;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zeroCounter = 0;
        int nonZeroCounter = 0;
        //We are moving nonZero elements to left by zeroCount at that moment.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCounter++;
            else {
                nonZeroCounter++;
                nums[i - zeroCounter] = nums[i];
            }
        }
        //Adding remaining zeroes at the end.
        for (int i = nonZeroCounter ; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
