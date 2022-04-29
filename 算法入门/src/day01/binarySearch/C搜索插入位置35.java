package day01.binarySearch;

public class C搜索插入位置35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 6;
        int index = searchInsert(nums, target);
        System.out.println(index);

    }

    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] > target)
                hi = mid-1;
            else if(nums[mid] < target)
                lo = mid+1;
            else
                return mid;
        }
        return lo;
    }
}
