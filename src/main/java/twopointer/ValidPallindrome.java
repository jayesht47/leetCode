package twopointer;


/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPallindrome {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        char[] input = s.toCharArray();

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && !isAlphNumChara(input[leftPointer])) //non lower case alphabetical character
                leftPointer++;
            while (rightPointer > 0 && !isAlphNumChara(input[rightPointer])) //non lower case alphabetical character
                rightPointer--;
            if (isAlphNumChara(input[leftPointer]) && isAlphNumChara(input[rightPointer]) && input[leftPointer] != input[rightPointer])
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    private boolean isAlphNumChara(char input) {
        if (input >= 97 && input <= 122)
            return true;
        else if (input >= 65 && input <= 90)
            return true;
        else return input >= 48 && input <= 57;
    }
}
