package com.ls.math_;

import java.util.ArrayList;
import java.util.List;

public class AFizzBuzz {

    public static void main(String[] args) {
        List<String> strings = fizzBuzz(1);
        System.out.println(strings);

    }


    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String tar;
            if(i % 15 == 0)
                tar = "FizzBuzz";
            else if(i % 3 == 0)
                tar = "Fizz";
            else if(i % 5 == 0)
                tar = "Buzz";
            else
                tar = i+"";
            res.add(tar);
        }
        return res;
    }
}
