package com.jianzhi;


/*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？
*/

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class movingCount_13 {

    //深度优先
    public static int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0) return 0;

        boolean visited[][] = new boolean[m][n]; //初始化访问标记 全false
        return dfs(m, n, 0, 0, k, visited);
    }

    public static int dfs(int m, int n, int i, int j, int k, boolean visited[][]) {
        if (i >= m || j >= n || visited[i][j] || k < calNum(i, j)) return 0; //只需要向下走或者向右走  不满足条件返回0
        visited[i][j] = true; //访问过的点标记
        return 1 + dfs(m, n, i + 1, j, k, visited) + dfs(m, n, i, j + 1, k, visited); //向下走和左走
    }

    //计算数位和的函数
    public static int calNum(int i, int j) {
        int n = 0;
        while (i > 0) {
            n += i % 10;
            i /= 10;
        }
        while (j > 0) {
            n += j % 10;
            j /= 10;
        }
        return n;
    }


    //广度优先
    public static int movingCount_bfs(int m, int n, int k) {
        if (m <= 0 || n <= 0) return 0;
        int count = 0;
        boolean visited[][] = new boolean[m][n]; //初始化访问标记 全false
        Queue<int[]> queue = new ArrayDeque<>(); //队列中保存i j的值
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            int[] out = queue.poll(); //获取并删除队首元素
            int i = out[0], j = out[1];
            if (i >= m || j >= n || k < calNum(i, j) || visited[i][j])
                continue; //不满足继续找下一个满足的点

            else {
                count += 1;
                visited[i][j] = true;
                queue.add(new int[]{i + 1, j});
                queue.add(new int[]{i, j + 1});
            }
        }
        return count;
    }



    /*总结一下广度优先和深度优先
     * 深度优先——递归
     * 广度优先——辅助栈
     *本题的剪枝：机器人只能往下走或者往右走
     * 借用一个visited数组标记是否访问过该点
     * */


    public static void main(String[] args) {
        int c = movingCount_bfs(18, 8, 4);
        System.out.println(c);
    }
}
