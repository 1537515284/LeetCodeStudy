package dual_pointer;

public class 反转单词前缀2000 {

    public static String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if(i < 0){
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0,i+1));
        return sb.reverse().append(word.substring(i+1)).toString();
    }

    public static void main(String[] args) {
        String str = "abcdefd";
        char ch = 'd';
        String reversePrefix = reversePrefix(str, ch);
        System.out.println(reversePrefix);
    }
}
