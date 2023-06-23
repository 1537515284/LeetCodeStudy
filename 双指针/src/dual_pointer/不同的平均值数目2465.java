package dual_pointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 不同的平均值数目2465 {

    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length/2; i++) {
            int sum = nums[i] + nums[nums.length - i -1];
            set.add(sum);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {4,1,4,0,3,5};
        int i = distinctAverages(nums);
        System.out.println(i);
    }
}
