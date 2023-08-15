package linkedlist;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDupe {
    public int findDuplicate(int[] nums) {

        int slowP = 0;
        int fastP = 0;

        do {
            slowP = nums[slowP];
            fastP = nums[nums[fastP]];
        } while (slowP != fastP);

        int newSlowP = 0;

        while (newSlowP != slowP) {
            slowP = nums[slowP];
            newSlowP = nums[newSlowP];
        }

        return slowP;

    }
}
