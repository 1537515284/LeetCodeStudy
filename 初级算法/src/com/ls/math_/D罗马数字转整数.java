package com.ls.math_;

import java.util.HashMap;
import java.util.Map;

public class D罗马数字转整数 {
    public static void main(String[] args) {
        int num = romanToInt2("IXI");
        System.out.println(num);
    }

    public static int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        // 所有可能都列出来
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int res = 0;
        for (int i = 0; i < s.length();) {
            // 先截取两个字符，如果这两个字符存在map中，就表示他们是一个整体。否则就截取一个
            if(i + 1 < s.length() && map.containsKey(s.substring(i,i+2))){
                res += map.get(s.substring(i,i+2));
                i += 2;
            }else {
                res += map.get(s.substring(i,i+1));
                i++;
            }
        }
        return res;
    }

    public static int romanToInt2(String s){
        int sum = 0;
        // 前一个数字表示的值
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            // 如果前一个数字比现在数字小，说明
            // 前一个字符和现在字符组合成一个有效数字。
            if(preNum < num){
                sum -= preNum;
            }else {
                // 如果前一个数字不比现在数字小，说明
                // 每个字符都是一个有效的数字
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch){
        switch (ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
