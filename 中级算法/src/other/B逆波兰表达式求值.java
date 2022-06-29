package other;

import java.util.Stack;

public class B逆波兰表达式求值 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        int numA;
        int numB;
        for (String token : tokens) {
            switch (token){
                case "+":
                    numA = numStack.pop();
                    numB = numStack.pop();
                    numStack.push(numB+numA);
                    break;
                case "-":
                    numA = numStack.pop();
                    numB = numStack.pop();
                    numStack.push(numB-numA);
                    break;
                case "*":
                    numA = numStack.pop();
                    numB = numStack.pop();
                    numStack.push(numB*numA);
                    break;
                case "/":
                    numA = numStack.pop();
                    numB = numStack.pop();
                    numStack.push(numB/numA);
                    break;
                default:
                    numStack.push(Integer.valueOf(token));
                    break;
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = evalRPN(tokens);
        System.out.println(i);

    }
}
