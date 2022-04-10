package com.ls.dp;

public class D打家劫舍 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int money = rob2(nums);
        System.out.println(money);


    }

    public static int rob(int[] nums) {
        // 边界条件判断
        if(nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;   // 第1家没偷
        dp[0][1] = nums[0]; // 第1家偷了
        for (int i = 1 ; i < length; i++) {
            // 下面两行是递推公式
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        // 最后取最大值即可
        return Math.max(dp[length-1][0],dp[length-1][1]);
    }

    // 动态规划优化
    public static int rob2(int[] nums){
        // 边界条件
        if(nums == null || nums.length ==0)
            return 0;
        int length = nums.length;
        int dp0 = 0;    // 第1家没偷
        int dp1 = nums[0];  // 第1家偷了
        for (int i = 1; i < length; i++) {
            //防止dp0被修改之后对下面运算造成影响，这里
            //使用一个临时变量temp先把结果存起来，计算完
            //之后再赋值给dp0.
            int temp = Math.max(dp0,dp1);
            dp1 = dp0+nums[i];
            dp0 = temp;
        }
        // 返回最大值即可
        return Math.max(dp0,dp1);
    }

}
