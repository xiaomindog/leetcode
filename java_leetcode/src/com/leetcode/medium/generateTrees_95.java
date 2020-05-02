package com.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
//不同的二叉搜索树

public class generateTrees_95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return recurse(1, n);
    }

    public LinkedList<TreeNode> recurse(int start, int end) {
        LinkedList<TreeNode> ans = new LinkedList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }

        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> left_trees = recurse(start, i - 1);
            LinkedList<TreeNode> right_trees = recurse(i + 1, end);

            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

}
