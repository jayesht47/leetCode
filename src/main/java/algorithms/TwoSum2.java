package algorithms;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {

    //TLE
    public int[] twoSumNaive(int[] numbers, int target) {
        int[] result = {1, 2};
        if (numbers.length == 2)
            return result;
        boolean breakFlag = false;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if ((numbers[i] + numbers[j] == target) && (i != j)) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = {1, 2};
        if (numbers.length == 2)
            return result;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            if ((numbers[left] + numbers[right]) > target)
                right -= 1;
            else
                left += 1;
        }
        return result;
    }

}
