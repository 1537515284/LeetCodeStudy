package com.ls.math_;

public class B计数质数 {
    public static void main(String[] args) {
        System.out.println(isPrimes(1));
        System.out.println(isPrimes(2));
        System.out.println(isPrimes(3));
        System.out.println(isPrimes(9));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes2(3));
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrimes(i))
                count++;
        }
        return count;
    }

    public static boolean isPrimes(int n){
        if(n <= 3)
            return n>1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }

    public static int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int num = 0;
        for (int i= 2; i<n; i++){
            if(!notPrime[i]){
                num++;
                for (int j = 2; i*j < n;j++)
                    notPrime[i*j] = true;
            }
        }
        return num;
    }

}
