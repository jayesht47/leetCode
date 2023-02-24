import arrays.Anagram;
import binarytree.CustomBinaryTree;

public class MainDriver {

    public static void main(String[] args) {

        Anagram anagram = new Anagram();

        String s = "aacc";
        String t = "ccca";

        System.out.println(anagram.isAnagram(s, t));

    }
}
