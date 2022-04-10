package arrayAndString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class D无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring2(s);
        System.out.println(i);

    }

    //双指针
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0,j=0; i < s.length(); i++) {
            //判断是否有重复的元素，如果有重复的元素，就更新j的值
            if(map.containsKey(s.charAt(i)))
                j = Math.max(j,map.get(s.charAt(i))+1);
            //把i指向的值存储到map中
            map.put(s.charAt(i),i);
            //更新j到i之间的最大距离，也就是无重复字符的最长子串
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    //使用队列
    public static int lengthOfLongestSubstring2(String s){
        //创建队列
        Queue<Character> queue = new LinkedList<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)){
                //如果有重复的，队头出队 直到没有重复的为止
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            //更新max
            max = Math.max(max,queue.size());
        }
        return max;
    }






















}
