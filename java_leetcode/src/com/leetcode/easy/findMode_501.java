package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 例如：
 * 给定 BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class findMode_501 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> ans = new ArrayList<>();
    int maxCount = 0, count = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        helper(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre == null) count = 1;
        if (pre != null && pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }

        if (count == maxCount) {  //如果当前值等于最大值 加入list
            ans.add(root.val);
        }

        if (count > maxCount) { //如果当前的数的计数器大于最大，去除之前的，更新众数
            maxCount = count;
            ans.clear();
            ans.add(root.val);
        }
        pre = root;
        helper(root.right);
    }
}
