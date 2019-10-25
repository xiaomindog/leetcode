package com.leetcode.easy;

import java.util.LinkedList;

public class hasPathSum_112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //DFS sum递减
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    //
    public boolean hasPathSum2(TreeNode root, int sum) {
        return getSum(root, 0, sum);
    }

    public boolean getSum(TreeNode p, int cur, int sum) {
        if (p == null)
            return false;
        cur+=p.val;
        if (p.left == null && p.right == null) {
            return cur == sum;
        }
        return getSum(p.left, cur, sum) || getSum(p.right, cur, sum);
    }

    //迭代
    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null)
            return false;
        LinkedList<TreeNode> node_stack = new LinkedList<>(); //作为栈使用
        LinkedList<Integer> sum_stack = new LinkedList<>();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        int cur_sum = 0; // 当前的总和
        while (!node_stack.isEmpty()) {
            TreeNode p = node_stack.pollLast(); // 获取并删除栈顶元素
            cur_sum = sum_stack.pollLast();
            //如果找到叶子节点 判断其路径和是否=sum
            if (p.left == null && p.right == null && cur_sum == 0) {
                return true;
            }
            ////没有找到继续往下 如果右结点非空 入栈 相当于先序遍历
            if (p.right != null) {
                node_stack.add(p.right);
                sum_stack.add(cur_sum - p.right.val);
            }
            if (p.left != null) {
                node_stack.add(p.left);
                sum_stack.add(cur_sum - p.left.val);
            }
        }
        return false;
    }


}
