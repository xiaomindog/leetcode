package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1：
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 */
public class averageOfLevels_637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<Integer> levCount = new ArrayList<>();
        helper(root, 0, ans, levCount);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) / levCount.get(i));
        }
        return ans;
    }

    public void helper(TreeNode root, int count, List<Double> ans, List<Integer> levCount) {
        if (root == null) return;
        if (count <= ans.size() - 1) {
            ans.set(count, ans.get(count) + root.val);
            levCount.set(count, levCount.get(count) + 1);
        } else {
            ans.add((double) root.val);
            levCount.add(1);
        }
        helper(root.left, count + 1, ans, levCount);
        helper(root.right, count + 1, ans, levCount);

    }
}
