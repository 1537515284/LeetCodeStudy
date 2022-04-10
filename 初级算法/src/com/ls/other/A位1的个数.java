package com.ls.other;

import jdk.jshell.execution.Util;

public class A位1的个数 {
    public static void main(String[] args) {
        int count = hammingWeight(13);
        int count2 = hammingWeight2(13);
        int count3 = hammingWeightBaiDu(13);
        System.out.println(count);
        System.out.println(count2);
        System.out.println(count3);

//        System.out.println(Integer.toBinaryString(Integer.valueOf("0f0f0f0f",16)));

    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    // 每两位存储，先运算再移位
    public static int hammingWeight2(int n){
        // 0xaaaaaaaa ==> 2进制：1010 1010 1010 1010 1010 1010 1010 1010
        // 0x55555555 ==> 2进制：0101 0101 0101 0101 0101 0101 0101 0101
        // 0xcccccccc ==> 2进制：1100 1100 1100 1100 1100 1100 1100 1100
        // 0x33333333 ==> 2进制：0011 0011 0011 0011 0011 0011 0011 0011
        // 0xf0f0f0f0 ==> 2进制：1111 0000 1111 0000 1111 0000 1111 0000
        // 0x0f0f0f0f ==> 2进制：0000 1111 0000 1111 0000 1111 0000 1111
        n = ((n & 0xaaaaaaaa) >>> 1) + (n & 0x55555555);
        n = ((n & 0xcccccccc) >>> 2) + (n & 0x33333333);
        n = ((n & 0xf0f0f0f0) >>> 4) + (n & 0x0f0f0f0f);
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 63;  // 过滤  63==> 2进制：0011 1111
    }

    // 使用api
    public static int hammingWeight3(int n) {
        return Integer.bitCount(n);
    }

    public static int hammingWeightBaiDu(int i)
    {
        i = (i & 0x55555555) + ((i >> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = (i & 0x0F0F0F0F) + ((i >> 4) & 0x0F0F0F0F);
        i = (i * (0x01010101) >> 24);
        return i;
    }
}
