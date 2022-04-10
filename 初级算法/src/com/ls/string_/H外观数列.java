package com.ls.string_;

public class H外观数列 {
    public static void main(String[] args) {
        String s = countAndSay(5);
        System.out.println(s);

    }

    public static String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = res;
            res = new StringBuilder();
            count = 1;
            // 遇到新的字符
            say = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if(prev.charAt(j) != say){
                    // 如果遇到了新的字符，把它的数量和字符都加入到res中，
                    // 然后count置为1，再把say赋予遇到的新的字符
                    res.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }else {
                    // 如果不是新的字符，计算当前字符的数量
                    count++;
                }
            }
            res.append(count).append(say);
        }
        return res.toString();
    }
}
