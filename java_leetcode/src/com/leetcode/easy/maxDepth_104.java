package com.leetcode.easy;

public class maxDepth_104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int mD(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(mD(root.left),mD(root.right))+1;
    }
}
