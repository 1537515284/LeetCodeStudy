package com.ls.other;

public class B汉明距离 {
    public static void main(String[] args) {
        int i = hammingDistance(0, 0);
        System.out.println(i);

    }

    public static int hammingDistance(int x, int y) {
        int t = x^y;
        return hammingWeight(t);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    // 使用api
    public static int hammingDistance2(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
