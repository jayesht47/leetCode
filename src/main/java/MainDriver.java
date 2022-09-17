import algorithms.*;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        rs.reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
    }
}
