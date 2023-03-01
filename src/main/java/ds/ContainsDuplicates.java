package ds;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicates {

    public boolean containsDuplicateInit(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            else
                set.add(num);
        }
        return false;
    }

}
