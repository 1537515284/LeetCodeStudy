package sortAndSearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class C数组中的第K个最大元素 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int kthLargest = findKthLargest4(nums, 2);
        System.out.println(kthLargest);

    }

    public static int findKthLargest(int[] nums, int k) {
        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp,(x,y)->y-x);
        return temp[k-1];
    }

    public static int findKthLargest2(int[] nums,int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //堆(优先队列)
    public static int findKthLargest3(int[] nums,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if(queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }

    //快排
    public static int findKthLargest4(int[] nums, int k) {
        k = nums.length-k;
        int lo = 0;
        int hi = nums.length-1;
        while (lo<=hi){
            int i = lo;
            //这里把数组以A[lo]的大小分为两部分，
            //一部分是小于A[lo]的，一部分是大于A[lo]的
            // [lo,i]<A[lo]，[i+1,j)>=A[lo]
            for (int j = lo+1; j <= hi; j++) {
                if(nums[j] < nums[lo])
                    swap(nums,j,++i);
            }
            swap(nums,lo,i);
            if(k == i)
                return nums[i];
            else if(k < i)
                hi = i-1;
            else
                lo = i+1;
        }
        return -1;
    }

    //交换元素
    private static void swap(int[] nums,int i,int j){
        if(i != j){
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

}
