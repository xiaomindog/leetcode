package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class pathSum_113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        dfs(root, sum, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int target, List<Integer> list) {
        if (root == null) return;
        target -= root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(list));
        }
        dfs(root.left, target, list);
        dfs(root.right, target, list);
        list.remove(list.size() - 1);
    }
}
