package day01;

public class 剑指_Offer30_包含min函数的栈 {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(4);
        obj.push(5);
        obj.push(3);
        obj.push(1);
        obj.push(5);
        obj.pop();
        int param_3 = obj.top();
        obj.pop();
        int param_4 = obj.min();
        System.out.println(param_3+","+param_4);
    }
}
