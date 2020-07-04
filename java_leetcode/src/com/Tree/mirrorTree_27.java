package com.Tree;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class mirrorTree_27 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //后序遍历模板
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
