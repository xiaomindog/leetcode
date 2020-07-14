package com.jianzhi;

import java.util.Stack;

//给定一棵二叉搜索树，请找出其中第k大的节点。
public class kthLargest_54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //迭代
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int n = 0;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.right;
            }
            p = stack.pop();
            n++;
            if (n == k) return p.val;
            p = p.left;
        }
        return 0;
    }

    //递归思路
    int count = 0;
    int res = -1;

    public int kthLargest_1(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        count++;
        if (count == k) res = root.val;
        dfs(root.left, k);
    }
}
