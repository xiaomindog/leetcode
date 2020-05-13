package com.leetcode.easy;

import com.leetcode.medium.lowestCommonAncestor_236;

public class lowestCommonAncestor_235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        //if (root == p || root == q) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            Integer val = node.val;
            if (p.val < val && q.val < val) {
                node = node.left;
            } else if (p.val > val && q.val > val) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }
}
