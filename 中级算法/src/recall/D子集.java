package recall;

import java.util.ArrayList;
import java.util.List;

public class D子集 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = (new D子集()).subsets(nums);
        System.out.println(subsets);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,nums,0,new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res,int[] nums,int start,List<Integer> tempList){

        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res,nums,i+1,tempList);
            tempList.remove(tempList.size()-1);
        }
    }


}
