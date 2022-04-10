package Introduction_to_two_dimensional_arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class B零矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}};
        setZeroes(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }


    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;      //行
        int n = matrix[0].length;   //列

        // row[i] 表示第i行是否有0
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // 第一遍遍历，确定哪些行哪些列含有零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // 把哪些含0的行和列 全部置为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(row[i] || col[j])
                    matrix[i][j] = 0;
            }
        }



//        for (int i = 0; i < row.length; i++) {
//            if(row[i])
//                Arrays.fill(matrix[i],0);
//            if(col[i]){
//                for (int j = 0; j < col.length; j++) {
//                    matrix[j][i] = 0;
//                }
//            }
//        }

    }
}
