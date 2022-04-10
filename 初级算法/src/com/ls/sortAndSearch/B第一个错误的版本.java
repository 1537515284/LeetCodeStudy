package com.ls.sortAndSearch;

public class B第一个错误的版本 {
    public static void main(String[] args) {
        int i = firstBadVersion2(5);
        System.out.println(i);

    }

    public static int firstBadVersion(int n) {
        for (int i = 1; i < n; i++) {
            if(isBadVersion(i) && isBadVersion(i+1))
                return i;
        }
        return n;
    }

    public static int firstBadVersion2(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi){
            int mid = lo+(hi-lo)/2;
            if(!isBadVersion(mid)){
                // 如果中位的版本 是正确版本
                // 排除前面的正确版本（包括中位），从后面继续找
                lo = mid+1;
            }
            else {
                // 如果中位的版本 是错误版本
                // 就可以排除中位之后的错误版本，从前面继续找
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean isBadVersion(int version){
        return version >= 4;
    }
}
