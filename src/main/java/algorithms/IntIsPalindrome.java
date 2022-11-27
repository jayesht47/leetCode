package algorithms;

/**
 * https://leetcode.com/problems/palindrome-number
 */
public class IntIsPalindrome {

    public boolean isPalindrome(int x) {
        String input = Integer.toString(x);
        int count = 0;
        while (count < input.length() / 2) {
            if (input.charAt(count) == input.charAt(input.length() - 1 - count))
                count++;
            else
                return false;
        }
        return true;
    }

}
