package day02.doublePointer;

import java.util.Arrays;

public class B轮转数组189 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for (int i = 0; i < len; i++) {
            nums[(i+k)%len] = temp[i];
        }
    }
}
