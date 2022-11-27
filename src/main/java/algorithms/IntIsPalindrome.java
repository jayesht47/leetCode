package algorithms;

/**
 * https://leetcode.com/problems/palindrome-number
 */
public class IntIsPalindrome {

    public int getIntLength(int input) {
        input = Math.abs(input);
        int len = 1;
        while ((input = (input / 10)) > 0)
            len++;
        return len;
    }

    public boolean isPalindrome(int x) {
        int modifiedInput = x;
        int newNumber = 0;
        while (modifiedInput > 0) {
            newNumber = (newNumber * 10) + (modifiedInput % 10);
            modifiedInput = modifiedInput / 10;
        }
        return newNumber == x;
    }

}
