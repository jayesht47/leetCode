package arrays;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsSeq {
    public int longestConsecutive(int[] nums) {
        Set<Integer> mem = new HashSet<>();
        Arrays.stream(nums).forEach(mem::add);
        int maxLength = 0;
        for (int num : nums) {
            int length = 0;
            //checking if start of a sequence by checking if left entry not present in set
            if (!mem.contains(num - 1)) {
                //checking if next element is present in set if so add to length
                while (mem.contains(num + length)) {
                    length++;
                }
                if (length > maxLength)
                    maxLength = length;
            }
        }
        return maxLength;
    }
}
