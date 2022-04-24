package math;

public class D实现Pow {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        double res = myPow(x, n);
        System.out.println(res);
    }

    public static double myPow(double x, int n) {
        long N  = n;
        return N >= 0 ? quickMul(x,N) : 1.0 / quickMul(x,-N);
    }

    public static double quickMul(double x,long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }


}
