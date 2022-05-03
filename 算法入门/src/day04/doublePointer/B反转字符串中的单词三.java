package day04.doublePointer;

import java.util.Arrays;

public class B反转字符串中的单词三 {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);


    }

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            res.append(new StringBuilder(split[i]).reverse().toString());
            if(i != split.length-1)
                res.append(" ");
        }
        return res.toString();
    }
}
