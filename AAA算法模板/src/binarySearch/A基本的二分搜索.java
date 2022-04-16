package binarySearch;

public class A基本的二分搜索 {

    /**
     * 基础二分查找，目标存在数组中返回其下标，否则返回-1
     * @param nums  目标数组，必须有序
     * @param target 待查找的目标
     * @return  位置
     */
    public static int binarySearch(int[] nums,int target) {
        int lo = 0;
        int hi = nums.length - 1;
        // 搜索区间为 [lo,hi];
        // 终止条件为 lo = hi+1;区间的形式就是 [right + 1, right]，
        // 或者带个具体的数字进去 [3, 2]，可见这时候区间为空，因为没有数字既大于等于 3 又小于等于 2
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] nums,int target) {
        int lo = 0;
        int hi = nums.length - 1;
        // 搜索区间为 [lo,hi); 左闭右开 漏掉了最后一个
        // 终止条件为 lo == hi; 区间形式为 [hi,hi] 或者带个具体的数字进去 [2, 2]，
        // 这时候区间非空，还有一个数 2，但此时 while 循环终止了。
        // 也就是说这区间 [2, 2] 被漏掉了，索引 2 没有被搜索
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            }
        }
        return nums[lo] == target ? lo : -1;    // 判断漏掉的元素 是不是目标值
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int target = 12;
        int idx = binarySearch(nums,target);
        System.out.println(target);
    }
}
