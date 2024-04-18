package easy;

public class LengthOfLastWord58 {

    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int start = chars.length-1;
        int end = 0;
        boolean flag = false;
        for (int i = chars.length-1; i >= 0;i--) {
            if(chars[i] != ' ' && !flag){
                start = i;
                flag = true;
            }
            else if(chars[i] == ' ' && flag){
                end = i+1;
                break;
            }
        }
        return start - end + 1;
    }

    public static int lengthOfLastWord2(String s) {

        int end = s.length()-1;
        while (s.charAt(end) == ' '){
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' '){
            start--;
        }
        return end-start;
    }

    public static void main(String[] args) {
        String s = "Hello world";
        System.out.println(lengthOfLastWord((s)));
        System.out.println(lengthOfLastWord2(s));
    }
}
