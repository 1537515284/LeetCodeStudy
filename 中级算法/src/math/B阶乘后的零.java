package math;

public class B阶乘后的零 {

    public static void main(String[] args) {
        int zeroCount = trailingZeroes2(10);
        System.out.println(zeroCount);

    }

    // 通过遍历 [1,n] 的所有 5 的倍数求出。
    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }

    // 优化计算
    // 通过不断将 n 除以 5，并累加每次除后的 n，来得到答案
    public static int trailingZeroes2(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
