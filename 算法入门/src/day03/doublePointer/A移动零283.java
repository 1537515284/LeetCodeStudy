package day03.doublePointer;

import java.util.Arrays;

public class A移动零283 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if(nums[left] != 0)
                left++;
            else if(nums[right] != 0){
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
        }
    }
}
