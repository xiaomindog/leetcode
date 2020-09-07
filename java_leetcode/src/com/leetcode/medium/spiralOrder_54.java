package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class spiralOrder_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> ans = new LinkedList<>();
        while (true) {
            //System.out.println("up:" + up + " " + "down:" + down + " " + "left:" + left + " " + "right:" + right);
            if (left > right) break;
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            down--;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2, 5, 8}, {-1, 0, 4}};
        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
}
