import algoDep.ListNode;
import algoDep.TreeNode;
import algorithms.*;
import line.Bingo;
import line.LogAnalyser;

import java.util.Arrays;

public class MainDriver {

    public static void main(String[] args) {

//        Integer[] test = {1,3,2,null,5};
//
//        TreeNode.generateBinaryTreeFromArr(test);

//        MinimumWindowSubstring mws = new MinimumWindowSubstring();
//
//        String s1 = "ADOBECODEBANC";
//        String s2 = "ABCZ";
//
//        System.out.println(mws.containsAllFrom2(s1, s2));
//        Bingo bingo = new Bingo();
//
//        System.out.println(bingo.solution(3, new int[]{1, 2, 3, 4, 5, 6 , 7 , 8 , 9},new int[] {1,3,5,9,12,11,7,4}));

        String[] test = new String[]{"10.20.31.12 200 http://example.com/index", "10.20.30.12 200 http://example.com/welcome", "10.20.31.11 200 http://example.com/index", "192.168.10.12 200 http://example.com/index", "192.168.15.12 404 http://example.com/nonono", "192.168.17.12 404 http://example.com/nonono"};


//        System.out.println(test[0].split(" ")[1].equals("200"));

        LogAnalyser logAnalyser = new LogAnalyser();

        System.out.println(logAnalyser.solution(2, test));


    }
}
