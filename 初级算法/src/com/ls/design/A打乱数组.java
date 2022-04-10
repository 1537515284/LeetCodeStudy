package com.ls.design;

import java.util.Arrays;
import java.util.Random;

public class A打乱数组 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Solution solution = new Solution(arr);
        int[] shuffle = solution.shuffle();
        System.out.println(Arrays.toString(shuffle));

        int[] shuffle1 = solution.shuffle();
        System.out.println(Arrays.toString(shuffle1));

        int[] reset = solution.reset();
        System.out.println(Arrays.toString(reset));


    }

}

class Solution {

    private int[] ori;

    public Solution(int[] nums) {
        ori = nums;
    }

    public int[] reset() {
        return ori;
    }

    public int[] shuffle() {
        Random random = new Random();
        int[] a = ori.clone();
        for (int i = 1; i < a.length; i++) {
            int j = random.nextInt(i+1);
            swap(a,i,j);
        }
        return a;
    }

    private void swap(int[] arr, int i,int j){
        if(i==j)
            return;

        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

}