package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class flatten_114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //直接原地修改  根左右
    public void flatten(TreeNode root) {
        TreeNode p = root;
        if (p == null) return;
        while (p != null) {
            if (p.left != null) {
                TreeNode temp = p.right;
                p.right = p.left;
                TreeNode r = p;
                while (r.right != null) {
                    r = r.right;
                }
                r.right = temp;
                p.left = null;
            }
            p = p.right;
        }
    }


    public void flatten_1(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new LinkedList<>();
        preOrder(root, list);
        TreeNode p = root;
        root.left = null;
        for (int i = 1; i < list.size(); i++) {
            p.right = list.get(i);
            p = p.right;
            if (p != null) {
                p.left = null;
            }
        }

    }

    public void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
