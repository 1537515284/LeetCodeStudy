package com.ls.string_;

public class B整数反转 {
    public static void main(String[] args) {
        int x = 123;
//        int num = reverse(x);
//        System.out.println(num);
        int max = 2147483647;
        int num2 = reverse2(max);
        System.out.println(num2);


    }

    public static int reverse(int x) {
        int res = 0;

        while (x!=0) {
            int t = x % 10;
            int newRes = res*10+t;
            // 如果数字溢出，直接返回0
            if((newRes - t) / 10 != res)
                return 0;
            res = newRes;
            x = x/10;
        }
        return res;
    }

    public static int reverse2(int x){
        long res = 0;
        while (x!=0){
            res = res*10+x%10;
            x/=10;
        }
        // 判断溢出
        return (int)res == res ? (int)res :0;
    }

}
