package day01;

import java.util.Stack;

class MinStack {

    private final Stack<Integer> inStack;
    private final Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        inStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        inStack.push(x);
        minStack.push(Math.min(x,minStack.peek()));
    }

    public void pop() {
        inStack.pop();
        minStack.pop();
    }

    public int top() {
        return inStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
