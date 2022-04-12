package sortAndSearch;

public class D寻找峰值 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);

    }

    public static int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi){
            int mid = lo+((hi-lo)>>1);
            if(nums[mid] > nums[mid + 1])
                hi = mid;
            else
                lo = mid+1;
        }
        return lo;
    }
}
