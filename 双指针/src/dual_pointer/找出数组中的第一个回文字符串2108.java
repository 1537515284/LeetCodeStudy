package dual_pointer;

public class 找出数组中的第一个回文字符串2108 {

    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if(isPalindrome(word))
                return word;
        }
        return "";
    }

    public static boolean isPalindrome(String word){
        char[] chars = word.toCharArray();
        int len = chars.length;
        for (int i = 0;i < len/2;i++){
            if(chars[i] != chars[len-i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String s = firstPalindrome(words);
        System.out.println(s);
    }
}
