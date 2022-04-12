package easy;

import java.util.Arrays;

public class 数组拆分一561 {
    public static void main(String[] args) {
//        int[] nums = {6,2,6,5,1,2};
        int[] nums = {1};
        int i = arrayPairSum(nums);
        System.out.println(i);

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }
}
