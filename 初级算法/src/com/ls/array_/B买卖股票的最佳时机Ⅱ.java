package com.ls.array_;

public class B买卖股票的最佳时机Ⅱ {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int profit = maxProfit(prices);
        System.out.println(profit);

    }

    public static int maxProfit(int[] prices) {
        int total = 0;
        int index = 0;
        int length = prices.length;
        while (index < length) {
            // 如果股票下跌就一直找，直到找到股票开始上涨为止
            while (index < length - 1 && prices[index] >= prices[index + 1])
                index++;
            // 股票上涨开始的值，也就是这段时间上涨的最小值
            int min = prices[index];
            // 一直找到股票上涨的最大值为止
            while (index < length - 1 && prices[index] <= prices[index + 1])
                index++;
            // 计算这段上涨时间的差值，然后累加
            total += prices[index++] - min;
        }
        return total;
    }

    public static int maxProfit2(int[] prices){
        int total = 0;
        for (int i = 0; i < prices.length-1; i++) {
            // 原数组中如果后一个减去前一个是正数，说明是上涨的，
            // 我们就累加，否则就不累加
            total += Math.max(prices[i+1] - prices[i],0);
        }
        return total;
    }

}
