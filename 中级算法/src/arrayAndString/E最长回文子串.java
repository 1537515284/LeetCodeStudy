package arrayAndString;

public class E最长回文子串 {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome3(s);
        System.out.println(s1);

    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        String longest = s;
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            for(int j = i+1; j<=s.length();j++){
                String substring = s.substring(i, j);
                if(maxlength < substring.length() && isPalindrome(substring)) {
                    longest = substring;
                    maxlength = substring.length();
                }
            }
        }
        return longest;
    }

//    public static boolean isPalindrome(String s) {
//        String rev = new StringBuffer(s).reverse().toString();
//        return s.equals(rev);
//    }

    public static boolean isPalindrome(String s){
        for(int i = 0,j= s.length()-1; i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public String longestPalindrome2(String s){
        if(s.length() < 2)
            return s;
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i; j < s.length(); j++) {
                //截取所有子串，如果截取的子串小于等于之前
                //遍历过的最大回文串，直接跳过。
                //因为截取的子串即使是回文串也不可能是最大的
                //所以不需要判断
                if(j-i < maxLen)
                    continue;
                if(isPalindrome2(s,i,j)){
                    if(maxLen < j - i + 1){
                        start = i;
                        maxLen = j-i+1;
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }

    //判断是否是回文串
    private static boolean isPalindrome2(String s, int start, int end) {
        while (start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static String longestPalindrome3(String s){
        //边界条件判断
        if(s.length() < 2)
            return s;
        //start表示最长回文串开始的位置
        //maxLen表示最长回文串的长度
        int start = 0;
        int maxLen = 0;
        int length = s.length();
        for (int i = 0; i < length;) {
            //如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
            //(因为即使它是回文子串，也不是最长的，所以直接终止循环，不再判断)
            if(length - i <= maxLen/2)
                break;
            int left = i;
            int right = i;
            while (right < length-1 && s.charAt(right+1) == s.charAt(right))
                ++right;    //过滤掉重复的
            //下次在判断的时候从重复的下一个字符开始判断
            i = right+1;
            //然后往两边判断，找出回文子串的长度
            while (right < length-1 && left >0 && s.charAt(right+1) == s.charAt(left-1)){
                ++right;
                --left;
            }
            //保留最长的
            if((right - left + 1) > maxLen){
                start = left;
                maxLen = right - left + 1;
            }
        }
        //截取回文子串
        return s.substring(start,start+maxLen);
    }

}
