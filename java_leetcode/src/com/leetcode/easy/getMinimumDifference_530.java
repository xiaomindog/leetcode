package com.leetcode.easy;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 示例：
 * 输入：
 * 1
 * \
 * 3
 * /
 * 2
 * 输出：
 * 1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 **/
public class getMinimumDifference_530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre == null) {
            pre = root;
        } else {
            min = Math.min(min, Math.abs(root.val - pre.val));
            pre = root;
        }
        helper(root.right);
    }
}
