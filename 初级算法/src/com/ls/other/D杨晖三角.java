package com.ls.other;

import java.util.ArrayList;
import java.util.List;

public class D杨晖三角 {
    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        System.out.println(list);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ls = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if(j ==0 || j == i){
//                    System.out.print(1);
                    ls.add(1);
                }
                else {
                    int num = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
//                    System.out.print(num);
                    ls.add(num);
                }
            }
//            System.out.println();
            res.add(ls);
        }
        return res;
    }
}
