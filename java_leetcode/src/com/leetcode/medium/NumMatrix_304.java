package com.leetcode.medium;

public class NumMatrix_304 {
    int sums[][];

    public NumMatrix_304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        sums[1][1] = matrix[0][0];

        for (int i = 1; i < matrix.length + 1; i++) {
            for (int j = 1; j < matrix[0].length + 1; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
