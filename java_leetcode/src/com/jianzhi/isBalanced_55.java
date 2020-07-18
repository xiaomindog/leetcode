package com.jianzhi;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 */
public class isBalanced_55 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //后序遍历 剪枝
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        //如果树高度差大于1 返回-1，否则向上返回树的深度
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    //先序遍历 判断深度
    public boolean isBalanced_1(TreeNode root) {
        if (root == null) return true;
        int h1 = getDepth(root.left);
        int h2 = getDepth(root.right);
        if (Math.abs(h1 - h2) > 1) return false;
        return isBalanced_1(root.left) && isBalanced_1(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left),
                getDepth(root.right)) + 1;
    }
}
