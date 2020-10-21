package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 现在你总共有 n 门课需要选，记为0到n-1。
 * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 示例1:
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释:总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例2:
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释:总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3] 。
 * 说明:
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 **/
public class findOrder_210 {

    //dfs
    int[] ans;
    int cnt;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans = new int[numCourses];
        cnt = numCourses;
        List<List<Integer>> adjacency = new ArrayList<>(); //邻接表
        for (int i = 0; i < numCourses; i++) { //顶点个数
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) { //边的个数
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return new int[0];
        }
        return ans;
    }

    public boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (int cur : adjacency.get(i)) {
            if (!dfs(adjacency, flags, cur)) return false;
        }
        flags[i] = -1;
        ans[--cnt] = i; //递归 自下而上 逆序的
        return true;
    }

    public int[] findOrder_1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>(); //邻接表
        int[] indegrees = new int[numCourses];//入度表
        for (int i = 0; i < numCourses; i++) { //顶点个数
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) { //边的个数
            indegrees[prerequisites[i][0]]++;
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int ans[] = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            ans[cnt++] = pre;
            for (int cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) queue.offer(cur);
            }
        }
        if (numCourses != 0) return new int[0];
        return ans;
    }
}
