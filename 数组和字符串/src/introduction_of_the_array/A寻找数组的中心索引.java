package introduction_of_the_array;

import java.util.Arrays;

public class A寻找数组的中心索引 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int i = pivotIndex(nums);
        System.out.println(i);

    }

    //暴力
    public static int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < nums.length; j++) {
                if(j <i)
                    leftSum += nums[j];
                else if(j > i)
                    rightSum += nums[j];
            }
            if(leftSum == rightSum)
                return i;
        }
        return -1;
    }

    //前缀和
    public static int pivotIndex2(int[] nums) {
//        int total = Arrays.stream(nums).sum();
        int total = 0;
        for (int num : nums) {
            total+=num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum*2 + nums[i] == total)
                return i;
            sum += nums[i];
        }
        return -1;
    }
}
