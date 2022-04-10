package com.ls.dp;

public class B买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit3(prices);
        System.out.println(i);

    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];
        // 边界条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            // 递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        // 毋庸置疑，最后肯定是手里没持有股票利润才会最大，也就是卖出去了
        return dp[length - 1][0];
    }

    // 代码优化
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int length = prices.length;
        int hold = -prices[0];  // 持有股票
        int noHold = 0; // 不持有股票
        for (int i = 1; i < length; i++) {
            // 递推公式
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        // 毋庸置疑，最后肯定是手里没有持有股票利润才会最大，
        // 也就是卖出了。
        return noHold;
    }

    // 双指针
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int maxPro = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxPro = Math.max(prices[i] - min, maxPro);
        }
        return maxPro;
    }
}






