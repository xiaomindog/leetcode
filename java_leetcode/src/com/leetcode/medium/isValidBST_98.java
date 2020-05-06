package com.leetcode.medium;


//验证二叉搜索树
public class isValidBST_98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //利用二叉搜索树的特性 中序遍历有序序列
    //int preVal = Integer.MIN_VALUE; // 这个会有测试点不过
    long preVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        boolean left = isValidBST(root.left);
        if (left == false || root.val <= preVal) {
            return false;
        }
        preVal = root.val;
        boolean right = isValidBST(root.right);
        return right;
    }
}
