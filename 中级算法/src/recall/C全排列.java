package recall;

import java.util.ArrayList;
import java.util.List;

public class C全排列 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = (new C全排列()).permute3(nums);
        System.out.println(permute);

    }

    //回溯
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,nums,new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res,int[] nums,List<Integer> oneList){
        //终止条件，如果数字都被使用完了，说明找到了一个排列，
        //（可以把它看做是n叉树到叶子节点了，不能往下走了，所以要返回
        if(oneList.size() == nums.length){
            //因为list是引用类型，必须要重新new一个
            res.add(new ArrayList<>(oneList));
            return;
        }
        //（可以把它看做是遍历n叉树每个节点的子节点）
        for (int i = 0; i < nums.length; i++) {
            //因为不能有重复的，所以有重复的就跳过
            if(oneList.contains(nums[i]))
                continue;
            //选择当前值
            oneList.add(nums[i]);
            //递归(可以看做遍历子节点的子节点)
            backtrack(res,nums,oneList);
            //撤销选择
            oneList.remove(oneList.size()-1);
        }
    }

    //回溯 交换两数
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack2(nums,0,res);
        return res;
    }

    private void backtrack2(int[] nums,int index,List<List<Integer>> res){
        //到最后一个数字，没法再交换了，直接把数组转化为list
        if(index == nums.length -1){
            //把数组转为list
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            //把list加入到res中
            res.add(tempList);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            //但前数字nums[index]要和后面所有的数字都要交换一遍（包括他自己)
            swap(nums,index,i);
            //递归，数组[0,index]默认是已经排列好的，然后从index+1开始
            //后面元素的交换
            backtrack2(nums,index+1,res);
            //还原回来
            swap(nums,index,i);
        }
    }

    //交换两个数字的值
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

    //递归
    public List<List<Integer>> permute3(int[] nums) {
        return helper(nums,0);
    }

    /**
     * @param nums
     * @param index 递归当前数字的下标
     * @return
     */
    private List<List<Integer>> helper(int[] nums, int index) {
        List<List<Integer>> res = new ArrayList<>();
        //递归的终止条件，如果到最后一个数组，直接把它放到res中
        if(index == nums.length-1){
            //创建一个临时集合
            List<Integer> temp = new ArrayList<>();
            //把数字nums[index]加入到临时数组中
            temp.add(nums[index]);
            res.add(temp);
            return res;
        }
        //计算后面数字的全排列
        List<List<Integer>> subList = helper(nums,index+1);
        //集合中每个子集的长度
        int count = subList.get(0).size();
        //遍历集合subList的子集
        for (int i = 0,size = subList.size(); i < subList.size(); i++) {
            //把当前数字nums[index]添加到子集的每一个位置
            for (int j = 0; j <= count; j++) {
                List<Integer> temp = new ArrayList<>(subList.get(i));
                temp.add(j,nums[index]);
                res.add(temp);
            }
        }
        return res;
    }

}
