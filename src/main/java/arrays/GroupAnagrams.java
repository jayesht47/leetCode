package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams
 */
public class GroupAnagrams {

    public  List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> occurrenceMap = new HashMap<>();

        for (String oneString : strs) {
            int[] count = new int[26];
            char[] oneCharArr = oneString.toCharArray();
            for (char c : oneCharArr) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    sb.append(count[i]);
                    sb.append((char) (i + 'a'));
                }
            }

            String finalKey = sb.toString();

            if (occurrenceMap.containsKey(finalKey))
                occurrenceMap.get(finalKey).add(oneString);
            else
                occurrenceMap.put(finalKey, new ArrayList<>(List.of(oneString)));

        }

        for (String key : occurrenceMap.keySet()) {
            res.add(occurrenceMap.get(key));
        }

        return res;

    }

}
