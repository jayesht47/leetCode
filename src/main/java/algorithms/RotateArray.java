package algorithms;


/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

    public void rotateInit(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newPosition = i + k >= nums.length ? i + k - nums.length : i + k;
            resultArr[newPosition] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = resultArr[i];
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
