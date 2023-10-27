package chapter1.sliding_window.Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();

        for(char c : p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if(valid == need.size()){
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Solution solution = new Solution();
        List<Integer> findAnagrams = solution.findAnagrams(s, p);
        System.out.println(findAnagrams);
    }
}
