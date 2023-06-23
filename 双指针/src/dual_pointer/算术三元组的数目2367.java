package dual_pointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 算术三元组的数目2367 {

    // 使用二分查找
    public static int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = Arrays.binarySearch(nums, nums[i] + diff);
            if (j > 0){
                int k = Arrays.binarySearch(nums, nums[j] + diff);
                if(k > 0){
                    count++;
                }
            }
        }
        return count;
    }

    // 使用set
    public static int arithmeticTriplets2(int[] nums, int diff) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if(set.contains(num+diff) && set.contains(num+diff*2))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,4,6,7,10};
        int diff = 3;
        int i = arithmeticTriplets(nums, diff);
        System.out.println(i);
    }
}
