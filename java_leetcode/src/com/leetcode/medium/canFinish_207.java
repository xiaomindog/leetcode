package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为0到numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释:总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释:总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <=numCourses <= 10^5
 */


public class canFinish_207 {

    //拓扑排序 .借助队列 广度优先
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[numCourses];//入度表
        List<List<Integer>> adjacency = new ArrayList<>(); //邻接表
        for (int i = 0; i < numCourses; i++) { //顶点个数
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) { //边的个数
            indegrees[prerequisites[i][0]]++; //计算入度
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //找到入度为0的表
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) { //当前结点下一个结点的列表
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    //DFS
    public boolean canFinish_1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>(); //邻接表
        for (int i = 0; i < numCourses; i++) { //顶点个数
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) { //边的个数
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    //从当前i结点出发是否存在环 存在返回false
    public boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false; //当前结点已访问过，不能再被访问
        if (flags[i] == -1) return true; //之前有结点访问过，直接返回true
        flags[i] = 1; //当前结点访问过标记
        for (int cur : adjacency.get(i)) {
            if (!dfs(adjacency, flags, cur)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
