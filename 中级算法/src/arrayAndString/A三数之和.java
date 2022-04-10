package arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum2(nums);
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length-1; i++) {
           if(i>0 &&  nums[i] == nums[i-1])
               continue;
            for (int j = i+1; j < length-1; j++) {
                List<Integer> list = new ArrayList<>();
                int k = Arrays.binarySearch(nums, j,nums.length,-nums[i] - nums[j]);
                if (k >= 0) {

                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            // 过滤掉重复的
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            // 因为是排序的，如果第一个数字大于0，那么后面的也都大于0
            // 它们三个数字的和不可能等于0
            if(nums[i] > 0)
                break;
            int left = i+1; // 左指针
            int right = nums.length-1;  // 右指针
            int target = -nums[i];
            while (left < right){
                // 左右指针的和
                int sum = nums[left] + nums[right];
                if(sum == target){
                    // 找到了一组，把他们加入到集合list中
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 过滤掉重复的
                    while (left < right && nums[left] == nums[left+1])
                        left++;
                    while (left < right && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }else if(sum < target)
                    left++;
                else
                    right--;
            }
        }
        return res;
    }
}
