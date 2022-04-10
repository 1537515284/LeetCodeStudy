package recall;

import java.util.ArrayList;
import java.util.List;

public class B括号生成 {
    public static void main(String[] args) {
        List<String> strings = (new B括号生成()).generateParenthesis(3);
        System.out.println(strings);

    }

    public List<String> generateParenthesis(int n) {
        List<String > res = new ArrayList<>();
        dfs(res,n,n,"");
        return res;
    }

    private void dfs(List<String > res,int left,int right,String curStr){
        if(left == 0 && right == 0){    //左右括号都不剩余了，说明找到了有效的括号
            res.add(curStr);
            return;
        }
        //左括号只有剩余的时候才可以选，如果左括号的数量已经选完了，是不能再选左括号了。
        //如果选完了左括号我们还是可以选择右括号的。
        if(left < 0)
            return;
        //如果右括号剩余数量小于左括号剩余的数量，说明之前选择的无效
        if(right < left)
            return;
        //选择左括号
        dfs(res,left-1,right,curStr+"(");
        //选择右括号
        dfs(res,left,right-1,curStr+")");
    }
}
