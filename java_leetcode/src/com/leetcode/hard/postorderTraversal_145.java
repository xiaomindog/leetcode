package com.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class postorderTraversal_145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        TreeNode p = root, r = null; //r结点用来表示当前的左孩子是否被访问
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            } //走到最左边的结点        
            p = stack.peek();
            if (p.right != null && p.right != r) { //存在右子树并且没有被访问则先访问右子树，否则访问该节点
                stack.push(p.right);
                p = p.right;
                p = p.left;
            } else {
                p = stack.pop();
                list.add(p.val);
                r = p;
                p = null; //让p指针不要乱指
            }
        }
        return list;
    }

    //前序：根->左->右
    //后序：左->右->根
    // 后序翻转  根->右->左 把后序当作前序然后在翻转一次
    public List<Integer> postorderTraversal_1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode p = stack.pop();
            list.add(0, p.val);
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }
        }
        return list;
    }

    //阿里面试题
    /*仅利用栈去判断该节点是否为父结点，创新性思路是每次在栈中压入父节点后压入null节点，
    之后再依次压入右子节点和左子节点。*/
    public List<Integer> postorderTraversal_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode p = stack.peek();
            if (p == null) {
                stack.pop();
                list.add(stack.pop().val);
            } else {
                stack.push(null);
                if (p.right != null) {
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                }
            }
        }
        return list;
    }

}
