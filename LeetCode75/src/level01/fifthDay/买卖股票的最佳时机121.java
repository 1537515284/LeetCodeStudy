package level01.fifthDay;

public class 买卖股票的最佳时机121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices){
        if(prices == null || prices.length ==0)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];
        // 边界条件
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i<length;i++){
            // 递推公式
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        // 毋庸置疑，最后肯定是手里没持有股票利润才会最大，也就是卖出去了
        return dp[length-1][0];
    }

    public static int maxProfit2(int[] prices){
        if(prices == null || prices.length ==0)
            return 0;
        int noHold = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            noHold = Math.max(noHold,hold+prices[i]);
            hold = Math.max(hold,-prices[i]);
        }
        return noHold;
    }

}
