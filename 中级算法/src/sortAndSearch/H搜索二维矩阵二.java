package sortAndSearch;

import java.util.Arrays;

public class H搜索二维矩阵二 {

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        boolean b = searchMatrix2(matrix, 5);
        System.out.println(b);

    }

    // 逐行二分查找 O(nlongn)
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if(Arrays.binarySearch(ints, target) >= 0)
                return true;
        }
        return false;
    }

    // Z字查找 O(m+n)
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n-1;
        while (x < m && y>=0){
            if(matrix[x][y] == target)
                return true;
            if(matrix[x][y] > target)
                --y;
            else
                ++x;
        }
        return false;
    }
}
