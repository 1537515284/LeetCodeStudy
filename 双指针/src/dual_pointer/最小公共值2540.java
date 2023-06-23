package dual_pointer;

import java.util.HashSet;
import java.util.Set;

public class 最小公共值2540 {

    // 哈希表
    public static int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if(set.contains(i))
                return i;
        }
        return -1;
    }

    // 双指针
    public static int getCommon2(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        while (left < nums1.length && right < nums2.length){
            if(nums1[left] == nums2[right]) {
                return nums1[left];
            } else if(nums1[left] < nums2[right]){
                left++;
            }else {
                right++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};
        int common = getCommon2(nums1, nums2);
        System.out.println(common);
    }
}
