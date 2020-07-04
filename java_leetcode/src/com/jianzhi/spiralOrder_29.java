package com.jianzhi;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

import java.util.ArrayList;
import java.util.List;

//蛇形矩阵
public class spiralOrder_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int[] nums = new int[matrix[0].length * matrix.length];
        int x = 0;
        //初始化左右上下边界
        int a = 0, b = matrix[0].length - 1, c = 0, d = matrix.length - 1;
        while (true) {
            for (int i = a; i <= b; i++) nums[x++] = matrix[c][i]; //从左到右
            if (++c > d) break; //上边界大于下边界 退出
            for (int i = c; i <= d; i++) nums[x++] = matrix[i][b]; //从上到下
            if (--b < a) break;//右边界小于左边界
            for (int i = b; i >= a; i--) nums[x++] = matrix[d][i];  //从右到左
            if (--d < c) break; //上边界小于下边界
            for (int i = d; i >= c; i--) nums[x++] = matrix[i][a]; //从下到上
            if (++a > b) break; // 左边界大于右边界
        }
        //return list.stream().mapToInt(Integer::valueOf).toArray();

        return nums;
    }
}
