package arrayAndString;

import java.util.*;

public class C字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {"eat"};
        List<List<String>> lists = groupAnagrams2(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        //map中key存储的是字符串中字母排序后新的字符串
        HashMap<String ,List<String >> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            //对字符数组进行排序
            Arrays.sort(chars);
            //排序之后再把它转化为一个字符串
            String key = String.valueOf(chars);
            //判断map中有没有这个字符串，如果没有这个字符串，
            //说明还没有出现和这个字符串一样的字母异位词，
            //要新建一个list，把它存放到map中
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            //把字符串存放到对应的list中
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    // 统计每个字母的个数
    public static List<List<String >> groupAnagrams2(String[] strs){
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String,List<String >> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = new char[26];
            //统计字符串中每个字符串出现的次数
            for (char c : str.toCharArray()) {
                ca[c-'a']++;
            }
            //将统计每个字符出现次数的数组转化为字符串
            String keyStr = String.valueOf(ca);
            if(!map.containsKey(keyStr))
                map.put(keyStr,new ArrayList<>());
            map.get(keyStr).add(str);

        }
        return new ArrayList<>(map.values());
    }



}
