package com.ls.other;

public class C颠倒二进制位 {


    public static void main(String[] args) {
        int i = reverseBits(18);
        System.out.println(i);

    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            // res先往左移一位，把最后一个位置空出来，
            // 用来存放n得最后一位数字
            res <<= 1;
            // res加上n的最后一位数字
            res |= n&1;
            // n往右移一位，把最后一位数字去掉
            n >>= 1;
        }
        return res;
    }

    public static int reverseBits2(int n){
        int res=0;
        // 把低16位移到高16上
        for (int i = 0; i < 16; i++) {
            res |= (n&(1<<i)) << (31 - i  *2);
        }
        // 把高16位移动到低16位上
        for (int i = 16; i < 32; i++) {
            res |= (n & (1 << i) >>> (i * 2 -31));
        }
        return res;
    }

}
