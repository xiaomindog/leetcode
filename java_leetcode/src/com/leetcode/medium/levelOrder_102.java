package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder_102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        DFS(root, 0, ans);
        return ans;
    }

    //通过列表的长度来确认是否添加子列表  列表的长度就是二叉树的高度
    public static void DFS(TreeNode p, int level, List<List<Integer>> ans) {
        if (p == null) {
            return;
        }
        if (ans.size() <= level) {
            List<Integer> t = new ArrayList<>();
            ans.add(t);
        }
        ans.get(level).add(p.val);

        DFS(p.left, level + 1, ans);
        DFS(p.right, level + 1, ans);
    }

    //借用辅助栈
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size(); //记录当前层的个数
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val); //当前层的节点加入该list
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] t = {2, 3, 4, 5};
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        List<List<Integer>> ans = levelOrder(t1);
        System.out.println(ans);

    }

}
