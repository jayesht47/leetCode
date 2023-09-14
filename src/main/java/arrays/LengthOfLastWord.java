package arrays;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int curWordLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                curWordLength++;
            } else {
                if (curWordLength > 0)
                    return curWordLength;
            }
        }
        return curWordLength;
    }
}
