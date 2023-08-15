package slidingwindow;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class StringInclusion {

    public boolean checkInclusion(String s1, String s2) {

        int[] mem = new int[26];
        int leftP = 0;
        int rightP = s1.length() - 1;

        for (char c : s1.toCharArray()) {
            mem[c - 97]++;
        }

        while (rightP < s2.length()) {
            if (checkIfContains(leftP, rightP, s2, mem))
                return true;
            leftP++;
            rightP++;
        }

        return false;

    }

    private boolean checkIfContains(int lp, int rp, String sm, int[] mem) {
        int[] internalMem = mem.clone();
        for (int i = lp; i <= rp; i++) {
            if (internalMem[sm.charAt(i) - 97] <= 0)
                return false;
            else
                internalMem[sm.charAt(i) - 97]--;
        }
        for (int j : internalMem) {
            if (j > 0)
                return false;
        }
        return true;
    }


}