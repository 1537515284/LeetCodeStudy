package binarySearch;

public class B寻找左侧边界的二分搜索 {

    public static int left_bound(int[] nums,int target){
        if(nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length;    // 注意

        // 因为 right = nums.length 而不是 nums.length - 1。
        // 因此每次循环的「搜索区间」是 [left, right) 左闭右开
        // 终止条件 left == right, 此时搜索区间 [left, left) 为空, 所以可以正确终止。
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;    // 注意
            }
        }
        // 这个索引 left 的含义可以解读为「nums 中小于 target 的元素有 left 个」。
//        return left;

        // 找不到返回-1
        // target 比所有数都大
        if(left == nums.length)
            return -1;
        return nums[left] == target ? left : -1;
    }

    public static int left_bound2(int[] nums,int target) {
        // 搜索区间为 [left,right]
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                // 搜索区间变为 [mid+1,right]
                left = mid + 1;
            else if (nums[mid] > target)
                // 搜索区间变为 [left,mid-1]
                right = mid - 1;
            else if (nums[mid] == target)
                // 收缩右侧边界
                right = mid - 1;
        }
        // 判断越界
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,5,7};
        int target = 2;
        int firstIdx = left_bound2(nums, target);
        System.out.println(firstIdx);

    }
}
