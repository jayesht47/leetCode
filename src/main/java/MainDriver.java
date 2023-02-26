import arrays.Anagram;
import arrays.GroupAnagrams;
import arrays.TopKFreq;
import binarytree.CustomBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainDriver {

    public static void main(String[] args) {

        TopKFreq topKFreq = new TopKFreq();
        int[] nums = {1,2};
        int k = 2;

        System.out.println(topKFreq.topKFrequent(nums,k));

    }
}
