package easy;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }
}


class MyStack {

    private Queue<Integer> queueA = new LinkedList<>();
    private Queue<Integer> queueB = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        queueB.offer(x);
        while (!queueA.isEmpty())
            queueB.offer(queueA.poll());
        Queue<Integer> temp = new LinkedList<>();
        temp = queueB;
        queueB = queueA;
        queueA = temp;
    }

    public int pop() {
        return queueA.poll();
    }

    public int top() {
       return queueA.peek();
    }

    public boolean empty() {
        return queueA.isEmpty();
    }
}

// 使用一个队列
class MyStack2 {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack2() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}