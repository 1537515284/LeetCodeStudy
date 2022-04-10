package dp;

public class C零钱兑换 {

    public static void main(String[] args) {
        int[] coins = {2,5,7};
        int amount = 27;
        int coinNums = coinChange(coins, amount);
        int coinNums2 = coinChange2(coins, amount);
        System.out.println(coinNums);
        System.out.println(coinNums2);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static int coinChange2(int[] coins,int amount){
        if(amount < 1)
            return 0;
        return coinChange2(coins,amount,new int[amount]);
    }

    private static int coinChange2(int[] coins,int rem,int[] count){
        if(rem < 0)
            return -1;
        if(rem == 0)
            return 0;
        if(count[rem-1] != 0)
            return count[rem-1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange2(coins,rem - coin,count);
            if(res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }
}
