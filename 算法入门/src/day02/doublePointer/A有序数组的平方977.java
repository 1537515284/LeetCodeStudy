package day02.doublePointer;

import java.util.Arrays;

public class A有序数组的平方977 {
    public static void main(String[] args) {
        int[] nums = {-5,-3,-2,-1};
        int[] ints = sortedSquares(nums);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int pos = len-1;
        for (int i = 0,j=len-1; i <= j ;) {
            if(nums[i]*nums[i] < nums[j]*nums[j]) {
                res[pos] = nums[j]*nums[j];
                j--;
            }else {
                res[pos] = nums[i]*nums[i];
                i++;
            }
            pos--;
        }
        return res;
    }

    public static int[] sortedSquares2(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0,j=n-1,pos=n-1;i<=j;){
            if(nums[i]*nums[i] > nums[j]*nums[j]){
                ans[pos] = nums[i] * nums[i];
                ++i;
            }else {
                ans[pos] = nums[j]*nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }


}
