package arrays;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        char[] inputChar = s.toCharArray();
        char[] testChar = t.toCharArray();

        int[] mem = new int[26];

        for (int i = 0; i < inputChar.length; i++) {
            mem[inputChar[i] - 'a']++;
        }

        for (int i = 0; i < testChar.length; i++) {
            mem[testChar[i] - 'a']--;
        }

        for (int i = 0; i < mem.length; i++) {
            if (mem[i] != 0)
                return false;
        }
        return true;

    }

}
