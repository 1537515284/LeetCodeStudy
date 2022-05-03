package day04.doublePointer;

public class A反转字符串 {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }



    public static void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length/2; i++) {
            char temp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = temp;
        }
    }
}
