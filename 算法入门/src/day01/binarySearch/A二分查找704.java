package day01.binarySearch;

public class A二分查找704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int index = search(nums, target);
        System.out.println(index);

    }

    public static int search(int[] nums, int target) {
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
        return -1;
    }
}
