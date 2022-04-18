package binarySearch;

public class D两端皆闭区间汇总 {

    public static int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] > target)
                right = mid -1;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static int left_bound(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] < target)
                left = mid+1;
            else if(nums[mid] > target)
                right = mid-1;
            else if(nums[mid] == target)
                right = mid-1;
        }
        if(left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public static int right_bound(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] > target)
                right = mid-1;
            else if(nums[mid] < target)
                left = mid+1;
            else if(nums[mid] == target)
                left = mid+1;
        }
        if(right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,7,7,9};
        int target = 0;
        int index = binarySearch(nums, target);
        int firstIdx = left_bound(nums, target);
        int lastIdx = right_bound(nums, target);

        System.out.println("binarySearch = "+index);
        System.out.println("left_bound = "+firstIdx);
        System.out.println("right_bound = "+lastIdx);

    }
}
