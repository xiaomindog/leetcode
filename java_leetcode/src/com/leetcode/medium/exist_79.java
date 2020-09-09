package com.leetcode.medium;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class exist_79 {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board.length == 0) return false;
        char[] chs = word.toCharArray();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, chs, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] chs, int idx) {
        if (idx >= chs.length) return true;
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != chs[idx]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '/'; //回溯
        if (dfs(board, i + 1, j, chs, idx + 1)
                || dfs(board, i, j + 1, chs, idx + 1)
                || dfs(board, i - 1, j, chs, idx + 1)
                || dfs(board, i, j - 1, chs, idx + 1)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
