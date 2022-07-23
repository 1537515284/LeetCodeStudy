package level01.secondDay;

public class 判断子序列392 {

    public static void main(String[] args) {
//        String s = "aaaaaa";
//        String t = "bbaaaa";
        String s = "aec";
        String t = "abcde";
        boolean res = isSubsequence(s, t);
        System.out.println(res);

    }

    public static boolean isSubsequence(String s, String t) {
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = t.indexOf(c, last);
            if(index == -1)
                return false;
            last = index+1;
        }
        return true;
    }
}
