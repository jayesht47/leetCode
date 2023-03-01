import arrays.EncodeDecodeString;
import arrays.LongestConsSeq;

import java.util.List;

public class MainDriver {

    public static void main(String[] args) {

        LongestConsSeq lcs = new LongestConsSeq();

        int[] nums = {1,2,0,1};

        System.out.println(lcs.longestConsecutive(nums));

    }
}
