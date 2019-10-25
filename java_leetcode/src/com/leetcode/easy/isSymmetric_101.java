package com.leetcode.easy;

public class isSymmetric_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //对称二叉树
    public boolean iSm(TreeNode root){
        if(root==null) {
            return true;
        }
        return sym(root.left,root.right);
    }
    public boolean sym(TreeNode q,TreeNode p){
        if(q==null&&p==null){
            return true;
        }
        if(q==null||p==null||q.val!=p.val){
            return false;
        }

        return sym(q.left,p.right)&&sym(q.right,p.left);
    }
}
