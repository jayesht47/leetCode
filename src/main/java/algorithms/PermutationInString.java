package algorithms;

/**
 * https://leetcode.com/problems/permutation-in-string/submissions/
 */
public class PermutationInString {

    private int[] getOccurrences(String input) {
        int[] occurrences = new int[128];
        for (int i = 0; i < input.length(); i++) {
            occurrences[input.charAt(i)]++;
        }
        return occurrences;
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int l = 0;
        int r = s1.length() - 1;
        int[] map = getOccurrences(s1);

        while (r < s2.length()) {
            int count = l;
            int[] tempMap = map.clone();
            boolean result = true;
            while (count <= r) {
                if (tempMap[s2.charAt(count)] > 0) {
                    tempMap[s2.charAt(count)]--;
                    count++;
                } else {
                    result = false;
                    break;
                }
            }
            if (result)
                return true;
            else {
                l++;
                r++;
            }
        }
        return false;
    }
}
