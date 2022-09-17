package algorithms;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsString3 {
    public String reverseWords(String s) {
        String[] splittedS = s.split(" ");
        for (int i = 0; i < splittedS.length; i++) {
            splittedS[i] = reverseString(splittedS[i]);
        }
        return String.join(" ", splittedS).toString();
    }

    private String reverseString(String s) {
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length / 2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[charArr.length - 1 - i];
            charArr[charArr.length - 1 - i] = temp;
        }
        return new String(charArr);
    }
}
