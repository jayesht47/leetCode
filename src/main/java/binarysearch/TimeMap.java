package binarysearch;


import java.util.*;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeMap {

    private Map<String, List<Map.Entry<Integer, String>>> mem;

    public TimeMap() {
        mem = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (mem.containsKey(key)) {
            mem.get(key).add(new AbstractMap.SimpleEntry<>(timestamp, value));
        } else {
            mem.put(key, new ArrayList<>());
            mem.get(key).add(new AbstractMap.SimpleEntry<>(timestamp, value));
        }

    }

    public String get(String key, int timestamp) {

        if (!mem.containsKey(key))
            return "";

        List<Map.Entry<Integer, String>> arr = mem.get(key);
        return getHighestPresentVal(arr, timestamp);
    }

    private String getHighestPresentVal(List<Map.Entry<Integer, String>> arr, int count) {
        String res = "";
        int start = 0;
        int end = arr.size() - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr.get(mid).getKey() <= count) {
                res = arr.get(mid).getValue();
                start = mid + 1;
            } else
                end = mid - 1;

        }
        return res;
    }
}
