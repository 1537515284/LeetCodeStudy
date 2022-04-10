package com.ls.string_;

public class F字符串转换整数atoi {
    public static void main(String[] args) {
        String str = "2147499999";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int index = 0;  // 遍历字符串中字符的位置
        int res = 0;    // 最终结果
        int sign = 1;   // 符号，1是正数，-1是负数，默认为正数
        int length = s.length();
        // 判断符号
        if(s.charAt(index) == '-' || s.charAt(index) == '+')
            sign = s.charAt(index++) == '+' ? 1 : -1;
        for (;index < length; ++index){
            // 取出字符串中字符，然后转化为数字
            int digit = s.charAt(index) - '0';
            // 按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            // 字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if(digit < 0 || digit > 9)
                break;
            // 越界处理
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                res = res * 10 + digit;
        }
        return sign * res;
    }

}
