package level01.firstDay;

public class 寻找数组的中心下标724 {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total+=num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(leftSum * 2 + nums[i] == total)
                return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}
