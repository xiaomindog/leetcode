package com.mianshijingdian;

//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

import java.awt.font.FontRenderContext;
import java.util.HashSet;

public class setZeroes_01_08 {

    // 一个不需要开辟一维set的方法
    public void setZeroes(int[][] matrix) {
        //1. 利用2个标记，保存第一行和第一列是否含0
        boolean row = false, column = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                column = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }
        //2. 利用第一行和第一列 存储该行或该列存在的0元素
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //3. 把存在0的非0行0列全部置为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (column) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public void setZeroes_1(int[][] matrix) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        int tmp[][] = matrix.clone();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j : set2) {
                tmp[i][j] = 0;
            }
        }
        for (int i : set1) {
            for (int j = 0; j < matrix[0].length; j++) {
                tmp[i][j] = 0;
            }
        }
        matrix = tmp;
    }
}
