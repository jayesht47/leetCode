import algoDep.ListNode;
import algorithms.*;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {

        PermutationInString ps = new PermutationInString();

        String s1 = "ab";
        String s2 = "eidbaooo";


        long start = System.currentTimeMillis();
        System.out.println(ps.checkInclusion(s1, s2));
        System.out.println("Time taken :: " + (System.currentTimeMillis() - start));

    }
}
