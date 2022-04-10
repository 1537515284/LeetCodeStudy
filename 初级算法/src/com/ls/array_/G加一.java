package com.ls.array_;

import java.util.Arrays;

public class G加一 {
    public static void main(String[] args) {
        int[] digits = {1,2,9};
        int[] arr1 = plusOne(digits);
        System.out.println(Arrays.toString(arr1));
        int[] digits2 = {9,9,9,9};
        int[] arr2 = plusOne(digits2);
        System.out.println(Arrays.toString(arr2));

    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length-1; i >=0; i--) {
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int temp[] = new int[length+1];
        temp[0] = 1;
        return temp;
    }
}
