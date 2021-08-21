package advanced;

import java.util.Arrays;

/**
 * @author:syx
 * @date:2021/8/20 13:10
 * @version:v1.0
 */
public class Of013 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix.print2D(matrix);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));

    }

}

class NumMatrix {
    private static int[][] help;
    private static int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        help = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                help[i][j] = sum;
            }
        }
        //print2D(help);
    }

    /**
     * 返会对应子矩阵的元素和
     *
     * @param row1 左上角
     * @param col1 左上角
     * @param row2 右下角
     * @param col2 右下角
     * @return 对应子矩阵的元素和
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2 ; i++) {
            result += help[i][col2]-help[i][col1]+matrix[i][col1];
        }
        return result;
    }

    public static void print2D(int[][] ranges) {
        for (int i = 0; i < ranges.length; i++) {
            System.out.println(Arrays.toString(ranges[i]));
        }
    }
}