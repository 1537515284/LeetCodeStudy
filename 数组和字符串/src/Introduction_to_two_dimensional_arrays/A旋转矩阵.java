package Introduction_to_two_dimensional_arrays;

import java.util.Arrays;

public class A旋转矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void rotate(int[][] matrix) {
        //上下交换
        int len = matrix.length;
        for (int i = 0; i < len/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[len-i-1];
            matrix[len-i-1] = temp;
        }

        //右对角线交换
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
