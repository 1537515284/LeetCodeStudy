package easy;

public class 分割平衡字符串1221 {
    public static void main(String[] args) {
        String  s = "RLLLLRRRLR";
        int i = balancedStringSplit(s);
        System.out.println(i);

    }

    public static int balancedStringSplit(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if(c == 'L')
                left++;
            else if(c == 'R')
                right++;
            if(left == right)
                count++;
        }
        return count;
    }
}
