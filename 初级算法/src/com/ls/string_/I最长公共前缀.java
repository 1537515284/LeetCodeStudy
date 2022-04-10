package com.ls.string_;

public class I最长公共前缀 {
    public static void main(String[] args) {
         String[] strs1 = {"flower","flower","flower"};
        String s1 = longestCommonPrefix1(strs1);
        String s3 = longestCommonPrefix1(new String[]{"sb"});
        System.out.println(s3);
        System.out.println(s1);

        String[] strs2 = {"dog"};
        String s2 = longestCommonPrefix2(strs2);
        System.out.println(s2);


    }

    public static String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String  target = strs[0];
        String prefix = "";
        for (int i = 1; i <= target.length(); i++) {
            prefix = target.substring(0,i);
            for (int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(prefix))
                    return prefix.substring(0,i-1);
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs){
        // 边界条件判断
        if(strs == null || strs.length ==0)
            return "";
        // 默认第一个字符串是它们的公共前缀
        String prefix = strs[0];
        int i = 1;
        while (i < strs.length){
            while (strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0,prefix.length()-1);
            i++;
        }
        return prefix;
    }
}
