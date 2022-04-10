package com.ls.math_;

public class C3的幂 {
    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree3(27);
        System.out.println(powerOfThree);

    }

    public static boolean isPowerOfThree(int n) {
        if(n < 1)
            return false;
        while (n%3 == 0){
            n/=3;
        }
        return n==1;
    }

    public static boolean isPowerOfThree2(int n){
        return n > 0 && (n == 1 || (n%3 == 0 && isPowerOfThree2(n/3)));
    }

    public static boolean isPowerOfThree3(int n){
        return (Math.log10(n)/Math.log10(3)) % 1 == 0;
    }

}
