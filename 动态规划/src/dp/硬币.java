package dp;

public class 硬币 {
    public static void main(String[] args) {
        int[] coins = {2,5,7};
        int money = 27;
        int nums = coinChange(coins, money);
        System.out.println(nums);

    }

    public static int coinChange(int[] coins,int money){
        int[] f = new int[money+1];
        int n = coins.length;

        // 初始化
        f[0] = 0;

        for (int i = 1; i <= money; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i-coins[j]]+1,f[i]);
                }
            }
        }

        if(f[money] == Integer.MAX_VALUE)
            f[money] = -1;

        return f[money];

    }
}
