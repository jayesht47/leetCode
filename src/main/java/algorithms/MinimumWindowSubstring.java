package algorithms;

import java.util.Arrays;

public class MinimumWindowSubstring {

//    public String minWindow(String s, String t) {
//
//        if (t.length() > s.length() || !containsAllFrom2(s, t))
//            return "";
//
//        int leftPointer = 0;
//        int rightPointer = t.length() - 1;
//
//        while (rightPointer < s.length()) {
//
//        }
//
//
//    }

    public boolean containsAllFrom2(String s1, String s2) {
        int counter2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(counter2))
                counter2++;
            if (counter2 == s2.length())
                break;
        }
        return counter2 == s2.length();
    }


    private boolean areAllTrue(boolean[] input) {
        for (boolean oneVal : input) {
            if (!oneVal)
                return false;
        }
        return true;
    }

}
