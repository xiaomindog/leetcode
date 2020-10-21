package com.mianshijingdian;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，
 * 也就是在原始的二叉搜索树上直接修改。
 * 返回转换后的单向链表的头节点。
 * 注意：本题相对原题稍作改动
 * 示例：
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 * 节点数量不会超过 100000。
 **/
public class convertBiNode_17_12 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode head = new TreeNode(-1); //头结点
    TreeNode r = head;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) return null;
        convertBiNode(root.left);
        TreeNode right = root.right; //防止right被修改 暂存
        root.right = null;
        if (head.right == null) {
            head.right = root;
            root.left = null;
            r = head.right;
        } else {
            r.right = root;
            root.left = null;//left已经被访问了 可以置为空
            r = r.right;
        }
        convertBiNode(right);
        return head.right;
    }


    //迭代
    public TreeNode convertBiNode_1(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1); //头结点
        dummyHead.right = null;
        TreeNode r = dummyHead, p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            TreeNode right = p.right;
            if (dummyHead.right == null) {
                dummyHead.right = p;
                p.left = null;
                r = p;
            } else {
                r.right = p;
                p.left = null;
                r = p;
            }
            p = right;
        }

        return dummyHead.right;
    }
}
