package sortAndSearch;

import java.util.*;

public class B前K个高频元素 {
    public static void main(String[] args) {
        int[] nums = {1,5,3,7,5,1,5,2,8,4,1,3,7,8,1,3,4,6,7,3,1};
        int k = 2;
        int[] ints = topKFrequent2(nums, k);
        System.out.println(Arrays.toString(ints));

    }

    //最大堆
    public static int[] topKFrequent(int[] nums, int k) {
        //先统计每个数字出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //最大堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for (int key : map.keySet()) {
            priorityQueue.add(new int[]{key,map.get(key)});
        }

        //取堆中最大的k个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;

    }

    //最小堆
    public static int[] topKFrequent2(int[] nums, int k) {
        //先统计每个数字出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //最小堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (int key : map.keySet()) {
            priorityQueue.add(new int[]{key,map.get(key)});
            if(priorityQueue.size()>k)
                priorityQueue.poll();
        }

        //把堆中的元素转化为数组
        int[] res = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()){
            res[index++] = priorityQueue.poll()[0];
        }
        return res;

    }
}
