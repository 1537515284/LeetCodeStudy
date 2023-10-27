package chapter1.sliding_window.Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        // 用于记录需要的字段和窗口中的字符及其出现的次数
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        // 统计 t 中各字符出现次数
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;  // 窗口中满足需要的字符个数
        
        // 记录最小覆盖字串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        while(right < s.length()){
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;    // 只有当 window[c] 和 need[c] 出现的次数一致时，才能满足条件，valid才能 +1
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;    // 只有当 window[d] 内的出现次数和 need[d] 相等时，才能 -1
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new Solution();
        String minWindow = solution.minWindow(s, t);
        System.out.println(minWindow);
    }
}
