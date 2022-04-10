package introduction_of_the_array;

public class B搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        int target = 8;
        int i = searchInsert(nums, target);
        System.out.println(i);

    }

    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] > target)
                hi = mid - 1;
            else if (nums[mid] < target)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public static int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
