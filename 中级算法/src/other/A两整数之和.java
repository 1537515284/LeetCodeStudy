package other;

public class A两整数之和 {

    public static int getSum(int a, int b) {
        while (b != 0){
            int carry = (a&b) << 1;
            a = a^b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int sum = getSum(a, b);
        System.out.println(sum);

    }
}
