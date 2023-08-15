package slidingwindow;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatCharRepl {

    public int characterReplacement(String s, int k) {

        char[] input = s.toCharArray();
        int leftP = 0;
        int rightP = 0;
        int res = 0;
        Map<Character, Integer> mem = new HashMap<>();

        while (rightP < input.length) {

            if (mem.containsKey(input[rightP]))
                mem.put(input[rightP], mem.get(input[rightP]) + 1);
            else
                mem.put(input[rightP], 1);

            if (isValidWindow(leftP, rightP, mem, k)) {
                res = Math.max(res, rightP - leftP + 1);
                rightP++;
            } else {
                while (!isValidWindow(leftP, rightP, mem, k) && leftP < rightP) {
                    mem.put(input[leftP], mem.get(input[leftP]) - 1);
                    leftP++;
                }
                rightP++;
            }

        }

        return res;


    }

    private boolean isValidWindow(int leftP, int rightP, Map<Character, Integer> mem, int k) {
        return (rightP - leftP + 1 - maxVal(mem)) <= k;
    }

    private int maxVal(Map<Character, Integer> mem) {
        if (mem.size() == 0) return 0;
        return Collections.max(mem.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
    }


}