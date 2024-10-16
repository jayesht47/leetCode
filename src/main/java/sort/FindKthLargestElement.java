package sort;

import java.util.Random;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return findElement(nums, k, 0, nums.length - 1);
    }

    private int findElement(int[] nums, int k, int start, int end) {

        //to get randomized pivot
        int randomIndex = new Random().nextInt(end - start) + start;
        swap(nums, randomIndex, end);

        int pivot = nums[end];

        int counter = start;

        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                if (nums[i] != nums[counter]) swap(nums, i, counter);
                counter++;
            }
        }

        // moving pivot to correct position
        swap(nums, counter, end);

        // checking number of larger elements to the right

        if (nums.length - counter == k)
            return pivot;

        if (nums.length - counter > k)
            return findElement(nums, k, counter + 1, end);

        return findElement(nums, k, start, counter - 1);

    }

    private void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
}
