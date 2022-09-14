package algorithms;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class IsBadVersion {

    private boolean isBadVersion(int n) {
        int firstBad = 1702766719;
        if (n >= firstBad)
            return true;
        return false;
    }

//    public boolean memoAPICall(boolean[] mem, int n) {
//        if (!mem[n]) {
//            mem[n] = isBadVersion(n);
//            return mem[n];
//        } else
//            return mem[n];
//    }

    public int firstBadVersion(int n) {
        if (n == 1)
            return 1;
        int start = 1;
        int end = n;
        int middle = n / 2;
        while (start <= end) {
            if (isBadVersion(middle) && !isBadVersion(middle - 1))
                return middle;
            if (isBadVersion(middle))
                end = middle - 1;
            else
                start = middle + 1;
            middle = start + (end - start) / 2;
        }
        return -1;//Illegal state
    }
}
