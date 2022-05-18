package dp;

public class A斐波那契数509 {


    // easy
    public int fib_1(int n) {
        if(n == 0 || n == 1)
            return n;
        return fib_1(n-1)+fib_1(n-2);
    }

    // 带备忘录的递归
    public int fib_2(int n){
        // 备忘录全初始化为0
        int[] memo = new int[n+1];
        // 进行带备忘录的递归
        return helper(memo,n);
    }

    public int helper(int[] memo,int n){
        if(n == 0 || n == 1)
            return n;
        // 已经计算过，不用再计算了
        if(memo[n] != 0)
            return memo[n];
        memo[n] = helper(memo,n-1) + helper(memo,n-2);
        return memo[n];
    }

    // dp数组的迭代解法
    public int fib_3(int n){
        if(n == 0)
            return 0;
        int[] dp = new int[n+1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // 空间优化
    int fib_4(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            // 滚动更新
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}
