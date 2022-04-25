package math;

public class E求X的平方根 {

    public static void main(String[] args) {
        int x = 8;
        int sqrt = mySqrtByBinarySearch(x);
        System.out.println(sqrt);

    }

    // 二分查找
    public static int mySqrtByBinarySearch(int x){
        int left = 0;
        int right = x;
        while (left <= right){
            int mid = left + (right-left)/2;
            long squ = (long) mid * mid;    // 防止溢出
            if(squ == x)
                return mid;
            else if(squ < x)
                left = mid+1;
            else
                right = mid-1;
        }
        return right;
    }

    // Math.exp(double a) 返回 e^a
    // Math.log(double a) 返回 lna(以e为底)
    public static int mySqrtByMath(int x) {
        if(x == 0)
            return 0;
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans+1)*(ans+1) <= x ? ans + 1 : ans;
    }
}
