package com.leetcode.medium;

import java.util.List;

/**
 * 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class generateMatrix_59 {
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n < 1) return ans;
        int c = 1;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        while (true) {
            if (left > right) break;
            for (int i = left; i <= right; i++) {
                ans[up][i] = c++;
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                ans[i][right] = c++;
            }
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--) {
                ans[down][i] = c++;
            }
            down--;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                ans[i][left] = c++;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] a = generateMatrix(3);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}
