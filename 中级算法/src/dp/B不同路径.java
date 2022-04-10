package dp;

import java.util.Arrays;

public class B不同路径 {
    public static void main(String[] args) {
        int i = (new B不同路径()).uniquePaths(3, 3);
        System.out.println(i);

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一列 置1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行 置1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
