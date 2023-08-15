package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray();

        for (int i = 0; i < nums.length; i++) {
            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            while (leftPointer < rightPointer) {
                List<Integer> oneTriplet = new ArrayList<>();
                int threeSum = nums[i] + nums[leftPointer] + nums[rightPointer];
                if (threeSum == 0) {
                    oneTriplet.add(nums[i]);
                    oneTriplet.add(nums[leftPointer]);
                    oneTriplet.add(nums[rightPointer]);
                    res.add(oneTriplet);
                    leftPointer++;
                    while ((nums[leftPointer] == nums[leftPointer - 1]) && leftPointer < rightPointer)
                        leftPointer++;
                } else if (threeSum > 0)
                    rightPointer--;
                else
                    leftPointer++;
            }
        }
        return res;
    }

}
