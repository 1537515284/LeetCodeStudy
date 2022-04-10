package sortAndSearch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A颜色分类 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
//        sortColorsBySelection(nums);
//        sortColorsByInsertion(nums);
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 三指针
    public static void sortColors(int[] nums){
        int left = 0;   // 0的右边界
        int right = nums.length-1;  //2的左边界
        int index = 0;  //指向当前数字
        while (index <= right){
            if(nums[index] ==0)
                swap(nums,left++,index++);      //如果是0，就往前面移
            else if(nums[index] == 1)
                index++;
            else if(nums[index] == 2)
                swap(nums,right--,index);       //如果是2就往后面移
        }
    }

    // 选择排序
    public static void sortColorsBySelection(int[] nums) {

        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[min] > nums[j])
                    min = j;
            }
            swap(nums,i,min);
        }
    }

    // 插入排序
    public static void sortColorsByInsertion(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for(int j=i;j>0 && nums[j] < nums[j-1];j--)
                swap(nums,j,j-1);
        }
    }

    // 交换
    private static void swap(int[] nums,int i,int j){
        if(i != j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


}
