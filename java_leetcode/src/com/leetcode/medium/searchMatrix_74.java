package com.leetcode.medium;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3   输出: true
 * target = 13  输出: false
 **/
public class searchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        //先确定行 比较每一行的最后一个
        int i = 0, j = m - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (matrix[mid][n - 1] == target) return true;
            else if (target > matrix[mid][n - 1]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (i == m) return false;
        int k = i;
        i = 0;
        j = n - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (target == matrix[k][mid]) return true;
            else if (target > matrix[k][mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
