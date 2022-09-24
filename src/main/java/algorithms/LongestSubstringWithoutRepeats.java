package algorithms;

public class LongestSubstringWithoutRepeats {

    public int lengthOfLongestSubstring(String s) {
        char[] inputArr = s.toCharArray();
        int[] storage = new int[128]; //going with 128 instead of 256
        int ans = 0;
        int leftPointer = 0, rightPointer = 0;
        while (rightPointer < inputArr.length) {
            storage[inputArr[rightPointer]]++;
            while (storage[inputArr[rightPointer]] > 1) {
                storage[inputArr[leftPointer]]--;
                leftPointer++;
            }
            ans = Math.max(ans, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return ans;
    }

}
