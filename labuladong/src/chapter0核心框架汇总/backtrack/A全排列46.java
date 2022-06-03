package chapter0核心框架汇总.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A全排列46 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录 [路径]
        LinkedList<Integer> track = new LinkedList<>();
        // [路径] 中的元素会被标记为 true,避免重复使用
        boolean[] used = new boolean[nums.length];

        backtrack(nums,track,used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 结束条件
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if(used[i])     // nums[i] 已经在track中，跳过
                continue;
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层
            backtrack(nums,track,used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = (new A全排列46()).permute(nums);
        System.out.println(permute);

    }

}
