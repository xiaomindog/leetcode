package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 示例 1:
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 */
public class isValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        //当前行的某个元素存在 0，1，2...9 有10个数字
        int[][] row = new int[9][10]; //判断每一行是否有重复
        int[][] col = new int[9][10];//判断每一列是否有重复
        int[][] box = new int[9][10]; //判断九宫格是否有重复 1表示重复
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '0';
                if (row[i][curNum] == 1) { //第i行存在curNum
                    return false;
                }
                if (col[j][curNum] == 1) {//第j列存在curNum
                    return false;
                }
                if (box[j / 3 + (i / 3) * 3][curNum] == 1) {
                    return false;
                }
                row[i][curNum] = 1;
                col[j][curNum] = 1;
                box[j / 3 + (i / 3) * 3][curNum] = 1;
            }
        }
        return true;
    }
}
