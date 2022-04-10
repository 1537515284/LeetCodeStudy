package arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F递增的三元子序列 {
    public static void main(String[] args) {
        int[] nums = {5,3,0,10,1,12};
        boolean b = increasingTriplet(nums);
        System.out.println(b);

    }

    // 超时....
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;

        for (int i = 0; i < nums.length-1; i++) {
            int mid = Integer.MAX_VALUE;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] > mid)
                    return true;
                else if(nums[i] < nums[j]) {
                    mid = nums[j];
                }
            }
        }
        return false;
    }


    public static boolean increasingTriplet2(int[] nums){
        //3个数字，small记录最小的数字
        int small = Integer.MAX_VALUE;
        //mid记录中间的数字
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num <= small) {
                //记录遍历过的最小值
                small = num;
            }
            else if(num <= mid) {
                //记录比small大的值，也就是mid的值
                mid = num;
            }
            else {
                //mid如果赋值了，那么之前肯定有个比mid小的值
                //这里又有个比mid大的值，所以它们三个可以构成递增的三元子序列
                return true;
            }
        }
        return false;
    }
}
