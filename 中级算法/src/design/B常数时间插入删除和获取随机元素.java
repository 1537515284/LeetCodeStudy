package design;

import java.util.*;

public class B常数时间插入删除和获取随机元素 {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean insert = randomizedSet.insert(1);// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println(insert);
        boolean remove = randomizedSet.remove(2);// 返回 false ，表示集合中不存在 2 。
        System.out.println(remove);
        boolean insert1 = randomizedSet.insert(2);// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(insert1);
        int random = randomizedSet.getRandom();// getRandom 应随机返回 1 或 2 。
        System.out.println(random);
        boolean remove1 = randomizedSet.remove(1);// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        System.out.println(remove1);
        boolean insert2 = randomizedSet.insert(2);// 2 已在集合中，所以返回 false 。
        System.out.println(insert2);
        int random1 = randomizedSet.getRandom();// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        System.out.println(random1);

    }
}

class RandomizedSet {

    List<Integer> list;
    Map<Integer,Integer> indices;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(indices.containsKey(val)){
            return false;
        }
        int size = list.size();
        list.add(val);
        indices.put(val,size);
        return true;
    }

    public boolean remove(int val) {
        if(!indices.containsKey(val)){
            return false;
        }
        int index = indices.get(val);
        int last = list.get(list.size()-1);
        list.set(index,last);
        indices.put(last,index);
        list.remove(list.size()-1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
