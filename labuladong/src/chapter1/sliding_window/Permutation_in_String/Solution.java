package chapter1.sliding_window.Permutation_in_String;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String t, String s) {
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> needs = new HashMap<>();

        for(char c : t.toCharArray()){
            needs.put(c, needs.getOrDefault(c, 0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if(needs.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(needs.get(c))){
                    valid++;
                }
            }

            while (right - left >= t.length()) {
                if(valid == needs.size()){
                    return true;
                }
                char d = s.charAt(left);
                left++;
                if(needs.containsKey(d)){
                    if(window.get(d).equals(needs.get(d))){
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0)-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution solution = new Solution();
       boolean isInClusion = solution.checkInclusion(s1, s2);
       System.out.println(isInClusion);
    }
}
