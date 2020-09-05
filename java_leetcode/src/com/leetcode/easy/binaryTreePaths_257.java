package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class binaryTreePaths_257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();
        if (root == null) return ans;
        dfs(root, "");
        return ans;
    }

    public void dfs(TreeNode T, String s) {
        if (T.left == null && T.right == null) {
            ans.add(s+T.val);
            return;
        }
        //根结点加入string
        //s += (T.val + '-' + '>');
        if (T.left != null) {
            dfs(T.left, s + T.val + '-' + '>');
        }

        if (T.right != null) {
            dfs(T.right, s + T.val + '-' + '>');
        }
    }
}
