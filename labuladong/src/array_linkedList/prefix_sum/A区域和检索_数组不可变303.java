package array_linkedList.prefix_sum;

public class A区域和检索_数组不可变303 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        int sumA = numArray.sumRange(1, 4);// return 1 ((-2) + 0 + 3)
        int sumB = numArray.sumRange(2, 5);// return -1 (3 + (-5) + 2 + (-1))
        int sumC = numArray.sumRange(0, 5);// return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))

        System.out.println(sumA);
        System.out.println(sumB);
        System.out.println(sumC);

    }
}

class NumArray {

    // 前缀和数组
    private final int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length+1];
        // preSum[0] = 0; 便于计算累加和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}
