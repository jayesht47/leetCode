package binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 */
public class SearchInRotatedArr {

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) return mid;

            //left part
            if (nums[start] <= nums[mid]) {
                if (target > nums[mid] || target < nums[start])
                    start = mid + 1;
                else
                    end = mid - 1;
            } else { //right part

                if (target < nums[mid] || target > nums[end])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }

}
