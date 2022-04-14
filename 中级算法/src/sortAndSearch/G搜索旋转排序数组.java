package sortAndSearch;

public class G搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = search2(nums, target);
        System.out.println(index);

    }

    //O(n)
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
        }
        return -1;
    }

    // 利用二分
    public static int search2(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target)
                return mid;

            // mid左右至少一端有序
            if(nums[mid] >= nums[lo]){  // 左端有序
                if(target < nums[mid] && target >= nums[lo]){
                    hi = mid-1;
                }else {
                    lo = mid+1;
                }
            }else { // 右端有序
                if(target > nums[mid] && target <= nums[hi]){
                    lo = mid+1;
                }else {
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}
