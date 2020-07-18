package com.jianzhi;

import java.util.Map;

//二叉树的深度
public class maxDepth_55 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    int level = 1;

    public int maxDepth_1(TreeNode root) {
        if (root == null) return 0;
        level++;
        maxDepth_1(root.left);
        maxDepth_1(root.right);
        level--;
        return level;
    }


}
