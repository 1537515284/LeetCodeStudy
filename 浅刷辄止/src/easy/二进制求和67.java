package easy;

public class 二进制求和67 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String result = addBinaryByDoublePointer(a, b);
        System.out.println(result);

    }

    //貌似溢出
    public static String addBinary(String a, String b) {
        long numA = Long.valueOf(a,2);
        long numB = Long.valueOf(b,2);
        long sum = numA+numB;
        return Long.toBinaryString(sum);
    }

    //双指针
    public static String addBinaryByDoublePointer(String a, String b) {
        StringBuilder res = new StringBuilder();
        int left = a.length()-1;
        int right = b.length()-1;
        int carry = 0;  // 进位
        while (left >= 0 || right >=0 || carry!=0){
            int numA = 0;
            if(left >= 0)
                numA = a.charAt(left--) - '0';
            int numB = 0;
            if(right >= 0)
                numB = b.charAt(right--) - '0';
            int numSum = numA+numB+carry;
            carry = numSum /2;
            res.insert(0,numSum%2);
        }
        return res.toString();
    }
}
