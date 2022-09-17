package ds;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Basically we need to check common elements in both arrays including dupes.
 * They <strong>DON'T</strong> have to be in same sequence.
 */
public class IntersectionTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        for (int k : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (k == nums2[j]) {
                    result.add(nums2[j]);
                    nums2[j] = -1; //removing that element once matched to avoid dupes.
                    break;
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
