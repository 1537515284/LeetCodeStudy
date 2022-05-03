package day03.doublePointer;

import java.util.Arrays;

public class B两数之和二输入有序数组 {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 13;
        int[] ints = twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));

    }


    public static int[] twoSum(int[] numbers, int target) {

        int length = numbers.length;
        for (int i = 0; i < length-1; i++) {
            int index = Arrays.binarySearch(numbers, i + 1, length, target-numbers[i]);
            if(index > -1)
                return new int[]{i+1,index+1};
        }
        return new int[]{};
    }
}
