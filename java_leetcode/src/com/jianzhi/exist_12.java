package com.jianzhi;

/*请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

*/
public class exist_12 {


    //深度优先搜索（DFS）+ 剪枝
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 ||
                j >= board[0].length || board[i][j] != word.charAt(k)) //不满足条件的点 直接返回false
            return false;
        if (k == word.length() - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/'; //表示该节点已经访问过（这边要考虑到是如何表示已经访问过的节点）
        boolean res = dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1)
                || dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1);
        //上下左右分别判断

        board[i][j] = tmp;
        return res;
    }


}
