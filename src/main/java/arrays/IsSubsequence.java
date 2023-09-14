package arrays;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty() && t.isEmpty())
            return true;
        if (s.isEmpty() && !t.isEmpty())
            return true;
        if (!s.isEmpty() && t.isEmpty())
            return false;
        int subSeqCounter = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(subSeqCounter))
                subSeqCounter++;
            if (subSeqCounter == s.length())
                return true;
        }
        return false;
    }
}
