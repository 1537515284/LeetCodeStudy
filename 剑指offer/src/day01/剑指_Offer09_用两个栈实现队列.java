package day01;

import java.util.Stack;

public class 剑指_Offer09_用两个栈实现队列 {
    public static void main(String[] args) {
        CQueue_2 queue = new CQueue_2();
        queue.appendTail(10);
        queue.appendTail(20);
        queue.appendTail(33);
        System.out.println(queue.deleteHead());
    }
}
