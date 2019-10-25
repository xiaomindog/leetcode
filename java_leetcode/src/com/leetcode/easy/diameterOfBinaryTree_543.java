package com.leetcode.easy;

public class diameterOfBinaryTree_543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //从下往上递归找到最大的直径，设置一个变量保存下来
    // 效率低 原因可能是递归了2次
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int max = Math.max(left, right);
        int s = hight(root.left) + hight(root.right);
        return max > s ? max : s;
    }

    public int hight(TreeNode t) {
        if (t == null) return 0;
        return Math.max(hight(t.right), hight(t.left)) + 1;
    }

    int ans = 0;  //全局变量

    public int diameterOfBinaryTree2(TreeNode root) {

        int s = depth(root);
        return ans;
    }


    public int depth(TreeNode t) {
        if (t == null) return 0;
        int l = depth(t.left);
        int r = depth(t.right);
        ans = Math.max(ans, l + r); //用全局变量保存当前的最大值
        return Math.max(l, r) + 1;
    }


}
