package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 */
public class TopKFreq {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer>[] countArr = new List[nums.length + 1];
        int[] res = new int[k];

        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        for (int num : map.keySet()) {
            if (countArr[map.get(num)] != null)
                countArr[map.get(num)].add(num);
            else
                countArr[map.get(num)] = new ArrayList<>(List.of(num));
        }

        int kCounter = 0;

        for (int i = countArr.length - 1; i > 0; i--) {
            if (kCounter < k) {
                if (countArr[i] != null ) {
                    for (int num : countArr[i])
                    {
                        res[kCounter] = num;
                        kCounter++;
                    }
                }
            }
        }

        return res;

    }

}
