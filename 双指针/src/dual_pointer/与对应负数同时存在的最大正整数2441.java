package dual_pointer;

import java.util.Arrays;

public class 与对应负数同时存在的最大正整数2441 {

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for (int num : nums) {
            if(num < 0 && Arrays.binarySearch(nums, -num) > 0){
                return Math.abs(num);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,10,6,7,-7,1};
        int maxK = findMaxK(nums);
        System.out.println(maxK);
    }
}
