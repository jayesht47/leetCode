import algorithms.BinarySearch;
import algorithms.IsBadVersion;

public class MainDriver {

    public static void main(String[] args) {
        IsBadVersion isBadVersion = new IsBadVersion();
        System.out.println(isBadVersion.firstBadVersion(2126753390));
    }
}
