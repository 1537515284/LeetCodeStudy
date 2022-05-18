package dp;

import java.util.Arrays;

public class B零钱兑换322 {



    // 暴力解法
    public int coinChange(int[] coins, int amount) {
        return dp(coins,amount);
    }

    private int dp(int[] coins, int amount) {
        // base case
        if(amount == 0) return 0;
        if(amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins,amount-coin);
            // 子问题无解则跳过
            if(subProblem == -1)
                continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res,subProblem+1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 带备忘录的递归

    int[] memo;

    int coinChange_2(int[] coins,int amount){
        memo = new int[amount+1];
        // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
        Arrays.fill(memo,-999);

        return dp_2(coins,amount);
    }

    private int dp_2(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        // 查看备忘录，防止重复计算
        if(memo[amount] != -999)
            return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp_2(coins,amount-coin);
            // 子问题无解则跳过
            if(subProblem == -1) continue;
            // 在子问题中选择最优解,然后加一
            res = Math.min(res,subProblem+1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    // dp数组
    public int coinChange_3(int[] coins,int amount){
        int[] dp = new int[amount+1];
        // 数组大小为 amount+1，初始值也为 amount+1
        Arrays.fill(dp,amount+1);

        // base case
        dp[0] = 0;
        // 外层for循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层for循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if(i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int count = (new B零钱兑换322()).coinChange_3(coins, amount);
        System.out.println(count);
    }
}
