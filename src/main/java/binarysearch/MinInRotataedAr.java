package binarysearch;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 */
public class MinInRotataedAr {

    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        int res = Integer.MAX_VALUE;
        while (start <= end) {
            if (nums[start] < nums[end]) //i.e array is complete sorted we can return leftmost element
                res = Math.min(res, nums[start]);

            res = Math.min(res, nums[mid]);

            if (nums[start] <= nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
            mid = (start + end) / 2;
        }
        return res;
    }

}
