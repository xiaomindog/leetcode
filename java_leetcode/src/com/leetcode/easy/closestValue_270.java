package com.leetcode.easy;

/**
 * Leetcode270. 最接近的二叉搜索树值
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 * 注意：
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 */
public class closestValue_270 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;
    double cnt = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return res;
    }

    public void helper(TreeNode root, double target) {
        if (root == null) return;
        if (Math.abs(target - root.val) < cnt) {
            res = root.val;
            cnt = Math.abs(target - root.val);
        }
        if (target > root.val) {
            helper(root.right, target);
        } else {
            helper(root.left, target);
        }
    }

    //非递归
    public int closestValue_1(TreeNode root, double target) {
        double close = Integer.MAX_VALUE;
        int res = 0;
        while (root != null) {
            if (Math.abs(target - root.val) < close) {
                res = root.val;
                close = Math.abs(target - root.val);
            }
            if (target > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }
}
