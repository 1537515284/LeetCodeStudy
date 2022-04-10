package com.ls.dp;

public class C最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray2(nums);
        System.out.println(i);

    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        // 边界条件
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            // 转移公式
            dp[i] = Math.max(dp[i-1],0)+nums[i];
            // 记录最大值
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    // 优化
    public static int maxSubArray2(int[] num) {
        int length = num.length;
        int cur = num[0];
        int max = cur;
        for (int i = 1; i < length; i++) {
            cur = Math.max(cur, 0) + num[i];
            //记录最大值
            max = Math.max(max, cur);
        }
        return max;
    }
}
