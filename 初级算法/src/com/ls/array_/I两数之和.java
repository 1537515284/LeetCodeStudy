package com.ls.array_;

import java.util.Arrays;
import java.util.HashMap;

public class I两数之和 {
    public static void main(String[] args) {
        int[] nums = {2,11,7,15};
        int target = 9;
        int[] twoNum = twoSum2(nums, target);
        System.out.println(Arrays.toString(twoNum));
    }

    public static int[] towSum1(int[] nums,int target){
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};

    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(target - nums[i]) != null)
                return new int[]{map.get(target-nums[i]),i};
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }

}
