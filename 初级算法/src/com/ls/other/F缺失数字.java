package com.ls.other;

import java.util.Arrays;

public class F缺失数字 {
    public static void main(String[] args) {
        int[]nums = {0};
        int i = missingNumber(nums);
        System.out.println(i);

    }

    public static int missingNumber(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] != i)
                return i;
        }
        return n;
    }

    public static int missingNumber2(int[] nums){
        int length = nums.length;
        // 等差数列公式
        // length+1 因为数组是少一位数的 比如 {3,0,1} length是 3 加上缺失的数 长度为 4
        int sum = (0+length)*(length+1)/2;
        // 减去数组中的数字 剩余的就是缺失得数字了
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static int missingNumber3(int[] nums){
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i] ^ (i+1);
        }
        return xor;
    }

}
