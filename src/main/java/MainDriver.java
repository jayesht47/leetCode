import algorithms.*;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {
        TwoSum2 twoSum = new TwoSum2();
        int[] nums = {5,25,75};
        int target = 100;
        int[] result = twoSum.twoSum(nums, target);
        Arrays.stream(result).forEach(System.out::print);
    }
}
