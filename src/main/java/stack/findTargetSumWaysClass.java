package stack;

import java.util.Arrays;

public class findTargetSumWaysClass {

    private int Calculate(int[] operands, boolean[] operators) {
        int result = 0;

        for (int i = 0; i < operands.length; i++) {

            if (operators[i])
                result += operands[i];
            else
                result -= operands[i];
        }

        return result;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int result = 0;

        if (nums.length == 1 && target == nums[0]) return 1;


        for (int i = 0; i < nums.length; i++) {

            boolean[] operators = new boolean[nums.length];

            operators[i] = false;

            if (Calculate(nums, operators) == target)
                result++;


        }

        return result;
    }


}
