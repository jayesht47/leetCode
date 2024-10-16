package sort;

import java.util.HashMap;
import java.util.Map;

public class BucketSort {
    public int[] sortArray(int[] input) {
        return bucketSort(input);
    }

    /**
     * To be used only when the input arrays elements are bounded by n distinct values
     *
     * @param input
     * @return sorted array
     */
    public int[] bucketSort(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int e : input) {
            if (map.containsKey(e)) map.put(e, map.get(e) + 1);
            else map.put(e, 1);
        }
        int counter = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int numOfElements = entry.getValue();
            while (numOfElements > 0) {
                input[counter] = entry.getKey();
                counter++;
                numOfElements--;
            }
        }
        return input;
    }
}
