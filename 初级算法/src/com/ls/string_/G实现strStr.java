package com.ls.string_;

public class G实现strStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int i = strStr3(haystack, needle);
        System.out.println(i);
//        System.out.println("a".indexOf(""));

        // "a".substring(0,0) = ""
        String substring = "a".substring(0, 0);


    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                // 如果不匹配，就回退，从第一次匹配的下一个开始
                i = i - j + 1;
                j = 0;
            }
            if(j == needle.length())
                return  i-j;
        }
        return -1;
    }

    public static int strStr2(String haystack,String needle){
        int length = needle.length();
        int total = haystack.length() - length + 1;
        for (int start = 0; start < total; ++start){
            if(haystack.substring(start,start+length).equals(needle))
                return start;
        }
        return -1;
    }

    public static int strStr3(String haystack,String needle){
        if(needle.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        int[] next = new int[needle.length()];
        getNext(needle,next);
        while (i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];    // j回到指定位置
            }
            if(j == needle.length())
                return i - j;
        }
        return -1;
    }

    private static void getNext(String p,int[] next){
        int len = p.length();
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < len -1){
            if(j == -1 || p.charAt(i) == p.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
    }
}
