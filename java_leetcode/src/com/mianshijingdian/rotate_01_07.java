package com.mianshijingdian;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
 * 请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 * 给定 matrix =
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [[7,4,1],
 * [8,5,2],
 * [9,6,3]]
 **/

public class rotate_01_07 {

    //法1：层层交换 每次交换4个点
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //x,y表示上下界 可以确定
        for (int x = 0, y = n - 1; x < y; x++, y--) {
            for (int s = x, e = y; s < y; s++, e--) {
                int temp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = temp;
            }
        }
    }


    //法2：考虑坐标轴的对称的性质
    public void rotate_1(int[][] matrix) {
        //考虑到坐标系里 先求关于y轴对称的点，再求其关于原点对称，则实现了顺时针旋转90°
        int n = matrix.length;
        //先求上下对称
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
        //对角线翻转        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
