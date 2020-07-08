package com.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal_144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root); //根结点入栈
        TreeNode p;
        while (!stack.empty()) {
            p = stack.pop();
            list.add(p.val);
            if (p.right != null) { //右节点先入栈 后出
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return list;
    }
}
