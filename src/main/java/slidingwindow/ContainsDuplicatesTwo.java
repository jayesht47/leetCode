package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicatesTwo {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        Set<Integer> window = new HashSet<>(k);
        for (int right = 0; right < nums.length; right++) {
            if (window.size() > k) {
                window.remove(nums[left]);
                left++;
            }
            if (window.contains(nums[right]))
                return true;
            window.add(nums[right]);
        }
        return false;
    }
}
