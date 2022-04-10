package com.ls.dp;

public class A爬楼梯 {
    public static void main(String[] args) {
        int i = climbStairs4(5);
        System.out.println(i);

    }

    // 超时...
    public static int climbStairs(int n) {
        if(n <= 1)
            return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    // 尾递归
    public static int climbStairs2(int n) {
       return Fibonacci(n,1,1);
    }

    public static int Fibonacci(int n,int a,int b){
        if(n <= 1)
            return b;
        return Fibonacci(n-1,b,a+b);
    }

    // 非递归
    public static int climbStairs3(int n){
        if(n <= 1)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 非递归优化
    public static int climbStairs4(int n){
        if(n <= 2)
            return n;
        int first = 1;
        int second = 2;
        int sum = 0;
        while (n-- > 2){
            sum = first+second;
            first = second;
            second = sum;
        }
        return sum;
    }


}
