package day01;

import java.util.Stack;

public class CQueue_2 {

    private final Stack<Integer> inStack;
    private final Stack<Integer> outStack;

    public CQueue_2() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if(outStack.isEmpty()){
            if(inStack.isEmpty()) {
                return -1;
            }
            in2out();
        }
        return outStack.pop();
    }

    public void in2out(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
