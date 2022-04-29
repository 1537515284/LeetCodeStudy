package day01.binarySearch;

public class B第一个错误的版本278 {
    public static void main(String[] args) {
        int n = 5;
        int badVersion = firstBadVersion(n);
        System.out.println(badVersion);

    }

    public static int firstBadVersion(int n) {
        int lo = 0;
        int hi = n;
        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            if(isBadVersion(mid))
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }

    private static boolean isBadVersion(int version){
        return version >= 4;
    }
}
