package com.ls.string_;

import java.time.format.SignStyle;
import java.util.Arrays;

public class 最长公共子串 {
    public static void main(String[] args) {
        String a = "lsanals153751lekkkkkk";
        String b = "ls15357wls153751klskkkkkls1537";
        String longestSubstring = findLongestSubstringByLs(a, b);
        System.out.println(longestSubstring);

    }

    public static String findLongestSubstringByLs(String a, String b) {

        if (a == null || b == null) {
            return "";
        }

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        StringBuilder builder = new StringBuilder();    //存放子串
        String temp = "";

        int point = 0;  //灵活的小指针
        for (int i = 0; i < charsA.length; i++) {
            point = i;
            for (int j = 0; j < charsB.length; j++) {
                if (charsA[point] == charsB[j]) {   //如果字符匹配成功，存放到builder中，point指针后移
                    builder.append(charsA[point]);
                    if(point+1 <charsA.length)
                        point++;
                } else if (builder.length() > 0) {          // 如果没有匹配成功，并且builder中字符不为空，就要回退指针并清空builder
                    point-=builder.length();                // point指针回退
                    builder.delete(0, builder.length());    // 清空builder
                }
                temp = builder.length() > temp.length() ? builder.toString() : temp;    //保留字符长度较长的子串
            }
        }
        return temp;
    }



    public static String findLongestSubstringByAlong(String a,String b){
        char[] aa;
        char[] bb;
        if(a.length() >= b.length()){
             aa = a.toCharArray();
             bb = b.toCharArray();

        }else {
             aa = b.toCharArray();
             bb = a.toCharArray();

        }

        char[] help = new char[Math.max(a.length(), b.length())];
        int begin = 0,sum=0,t=0,ii=0,kk=0,end=0;
        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < bb.length; j++) {
                if(aa[i] == bb[j]){
                    if(begin == 0)
                        begin = j;

                    sum++;

                }
                end=j-1;
                break;
            }

            if(sum >= t){
                for(int k=begin;k<=end;k++){
                    help[kk] = bb[k];
                    kk++;
                }
                kk=0;
                t=sum;
            }

            begin = 0;
        }
        return new String(help);
    }


}
