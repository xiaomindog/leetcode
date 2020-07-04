package com.jianzhi;

import java.util.ArrayList;
import java.util.List;

//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
public class levelOrder_32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelPrint(root, ans, 0);
        return ans;
    }

    public void levelPrint(TreeNode root, List<List<Integer>> ans, int level) {
        if (root == null) return;
        if (ans.size() <= level) {
            List<Integer> t = new ArrayList<>();
            ans.add(t);
        }
        ans.get(level).add(root.val);
        levelPrint(root.left, ans, level + 1);
        levelPrint(root.right, ans, level + 1);
    }

}
