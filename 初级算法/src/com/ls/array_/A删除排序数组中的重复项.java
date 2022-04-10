package com.ls.array_;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 */
public class A删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        int k= removeDuplicates(arr);
        System.out.println(k);
        System.out.println(Arrays.toString(arr));
    }


    public static int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if(nums[left] != nums[right])
                nums[++left] = nums[right];
        }
        return ++left;
    }
}
