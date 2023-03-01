package ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Basically we need to check common elements in both arrays including dupes.
 * They <strong>DON'T</strong> have to be in same sequence.
 */
public class IntersectionTwoArrays2 {

    //Has O(mn) time.
    public int[] intersectNaive(int[] nums1, int[] nums2) {
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

    //Uses hashmap to store counts
    public int[] intersectHashMap(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums1) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                resultList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] counts = new int[1001]; //used to store counts.
        List<Integer> resultArr = new ArrayList<>();
        for (int num : nums1) counts[num] = ++counts[num];

        for (int j : nums2) {
            if (counts[j] > 0) {
                resultArr.add(j);
                counts[j]--;
            }
        }

        int[] res = new int[resultArr.size()];
        int counter = 0;
        for (int num : resultArr) res[counter++] = num;
        return res;
    }

}
