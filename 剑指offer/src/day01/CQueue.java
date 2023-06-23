package day01;

import java.util.Stack;

class CQueue {

    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void appendTail(int value) {
        if (stackB.isEmpty()) {
            stackB.push(value);
        }else {
            int sizeB = stackB.size();
            for (int i = 0; i < sizeB; i++) {
                stackA.push(stackB.pop());
            }
            stackB.push(value);
            int sizeA = stackA.size();
            for (int i = 0; i < sizeA; i++) {
                stackB.push(stackA.pop());
            }
        }
    }

    public int deleteHead() {
        return !stackB.isEmpty() ? stackB.pop() : -1;
    }
}
