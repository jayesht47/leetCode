import algorithms.BinarySearch;
import algorithms.IsBadVersion;
import algorithms.SearchInsertPosition;

public class MainDriver {

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(s.searchInsert(nums, target));
    }
}
