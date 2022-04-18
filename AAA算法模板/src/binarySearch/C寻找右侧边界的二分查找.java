package binarySearch;

public class C寻找右侧边界的二分查找 {

    public static int right_bound(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        // 因为right = nums.length， 搜索区间为 [left,right)
        while (left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] == target){
                left = mid+1;   // mid = left - 1
            }else if(nums[mid] > target){
                right = mid;
            }
        }

//        return right-1;

        // 判断
        if(right == 0)
            return -1;
        return nums[right-1] == target ? right-1 : -1;

    }

    public static int right_bound2(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        // 搜索区间为 [left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                // 搜索区间变为 [left,mid-1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为 [mid+1,right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 向左侧收缩
                left = mid + 1;
            }
        }
        // 检查right越界
        if(right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,7,7,9};
        int target = 0;
        int lastIdx = right_bound2(nums, target);
        System.out.println(lastIdx);

    }
}
