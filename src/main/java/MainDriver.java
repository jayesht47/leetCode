import arrays.Anagram;
import arrays.GroupAnagrams;
import binarytree.CustomBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MainDriver {

    public static void main(String[] args) {

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams.groupAnagrams(strs));

    }
}
