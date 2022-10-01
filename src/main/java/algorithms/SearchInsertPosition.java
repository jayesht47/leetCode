package algorithms;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start, middle, end;
        start = 0;
        middle = nums.length / 2;
        end = nums.length - 1;
        while (start <= end) {
            if (nums[middle] == target)
                return middle;
            if (target > nums[middle])
                start = middle + 1;
            else
                end = middle - 1;
            middle = (start + end) / 2;
        }
        return start;
    }

}
