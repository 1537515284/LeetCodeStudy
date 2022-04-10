package arrayAndString;

import java.util.*;

public class B矩阵置零 {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}};
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        setZeroes3(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }


    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;  // 行
        int n = matrix[0].length;   // 列
        // k 行，v 一个包含列的集合
        HashMap<Integer, List<Integer>> temp = new HashMap<>();
        // 记录下需要置0的行-列
         for (int i = 0; i < m; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0)
                    col.add(j);
            }
            if(col.size() > 0)
                temp.put(i,col);
        }
//        System.out.println(temp);

        // 根据集合中存的 行-列 置0
        Set<Integer> integers = temp.keySet();
        for (Integer integer : integers) {
//            System.out.println(integer +" = "+ temp.get(integer));
            List<Integer> list = temp.get(integer);
            // 置行为0
            for (int j = 0; j < n; j++) {
                matrix[integer][j] = 0;
            }

            // 置列为0
            for (Integer col : list) {
                for (int i = 0; i < m; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
    }

    // 优化 使用俩个临时数组
    public static void setZeroes2(int[][] matrix){
        int m = matrix.length;  // 行
        int n = matrix[0].length;   // 列
        // row[i] 表示第i行是否有0
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // 第一次遍历，确定哪些行哪些列应该为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前位置是0，那么当前的行
                // 和当前的列都应该标注为0
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        // 把那些应该为0的行和列全部置为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(row[i] || col[j])
                    matrix[i][j] = 0;
            }
        }
    }

    public static void setZeroes3(int[][] matrix){
        boolean row = false;    // 标记第一行是否有数字0
        boolean col = false;    // 标记第一列是否有数字0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    // 如果第一行或者第一列本来就有0，就把他标记一下
                    // 最后再把第一行或这第一列全部置为0
                    if(i==0)
                        row =true;
                    if(j==0)
                        col = true;
                    // 把最上面一行和最左边一列对应的位置标注为0
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        // 把那些应该为0的行和列全部置为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        // 如果第一列本来就有0，就把第一列全部变为0
        if(col){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        // 如果第一行本来就有0，把第一行全部变为0
        if(row){
            Arrays.fill(matrix[0], 0);
        }
    }


}
