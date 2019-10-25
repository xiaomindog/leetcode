package com.leetcode.easy;

public class minDepth_111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1; //找到叶子结点
        if(root.left!=null&&root.right!=null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if(root.right==null)
            return 1+minDepth(root.left);

        return 1+minDepth(root.right);
    }

}
