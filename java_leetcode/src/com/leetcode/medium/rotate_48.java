package com.leetcode.medium;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
public class rotate_48 {


    //从内到外 按圈层进行旋转
    public void rotate(int[][] matrix) { //nxn的方阵
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < m - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - j][i];
                matrix[m - 1 - j][i] = matrix[m - 1 - i][m - 1 - j];
                matrix[m - 1 - i][m - 1 - j] = matrix[j][m - 1 - i];
                matrix[j][m - 1 - i] = temp;
            }
        }
    }


    //先左右翻转 在按原点翻转
    public void rotate_1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        //左右翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }

        //对角翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][m - 1 - i];
                matrix[n - 1 - j][m - 1 - i] = t;
            }
        }

    }
}
