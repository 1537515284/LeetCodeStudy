package level01.firstDay;

import java.util.Arrays;

public class 一维数组的动态和1480 {

    public static void main(String[] args) {
        int[] nums = {3,1,2,10,1};
        int[] ints = runningSum(nums);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        res[0] = nums[0];

        for (int i = 1; i < length; i++) {
            res[i] = nums[i] + res[i-1];
        }
        return res;
    }
}
