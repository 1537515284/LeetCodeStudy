package easy;

import java.util.Arrays;

public class 增减字符串匹配942 {
    public static void main(String[] args) {
        String  s = "IDID";
        int[] ints = diStringMatch(s);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] diStringMatch(String s) {
        int N = s.length();
        int lo = 0;
        int hi = N;
        int[] ans = new int[N+1];
        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }
        ans[N] = lo;
        return ans;
    }
}
