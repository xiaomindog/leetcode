package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class rightSideView_199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //dfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root, 0);
        return ans;
    }

    public void dfs(List<Integer> ans, TreeNode root, int depth) {
        if (root == null) return;
        if (depth >= ans.size()) {
            ans.add(root.val);
        }
        dfs(ans, root.right, depth + 1);
        dfs(ans, root.left, depth + 1);
    }

    //bfs 宽度优先搜索
    public List<Integer> rightSideView_1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (i == 0) {
                    ans.add(p.val);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
            }
        }
        return ans;
    }
}
