package com.jianzhi;

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrder_32_I {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //层次遍历的思想
    public int[] levelOrder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            ans.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }
        int[] nums = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            nums[i] = ans.get(i);
        }
        return nums;
    }
}
