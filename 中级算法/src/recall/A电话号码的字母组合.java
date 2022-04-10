package recall;

import java.util.*;

public class A电话号码的字母组合 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = (new A电话号码的字母组合()).letterCombinations(digits);
        List<String> strings2 = (new A电话号码的字母组合()).letterCombinations2(digits);
        System.out.println(strings);
        System.out.println(strings2);

    }



    //回溯
    public List<String> letterCombinations(String digits) {
        List<String > combinations = new ArrayList<>();
        if(digits.length() == 0)
            return combinations;
        Map<Character,String > map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(combinations,map,digits,0,new StringBuffer());
        return combinations;
    }

    /**
     *
     * @param combinations     结果
     * @param map       存放数字对应的字符
     * @param digits    数字
     * @param index     访问到第几个数字了，也可以认为访问到树的第几层了
     * @param combination       路径
     */
    private void backtrack(List<String > combinations,Map<Character,String> map,String digits,int index,StringBuffer combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,map,digits,index+1,combination);
                combination.deleteCharAt(index);
            }

        }
    }

    //BFS
    public List<String > letterCombinations2(String digits){
        LinkedList<String > res = new LinkedList<>();
        //空判断
        if(digits == null || digits.isEmpty())
            return res;
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        res.add("");
        while (res.peek().length() != digits.length()){
            String remove = res.poll(); //出队
            char[] chars = tab[digits.charAt(remove.length()) - '2'];
            //相当于当前节点的所有子节点
            for (int i = 0; i < chars.length; i++) {
                res.add(remove + chars[i]); //入队
            }
        }
        return res;
    }
}
