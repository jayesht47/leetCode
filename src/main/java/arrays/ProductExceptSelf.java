package arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int preFix = 1;
        int postFix = 1;
        result[0] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            preFix = preFix * nums[i];
            result[i + 1] = preFix;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = postFix * result[i];
            postFix = postFix * nums[i];
        }
        return result;
    }
}



