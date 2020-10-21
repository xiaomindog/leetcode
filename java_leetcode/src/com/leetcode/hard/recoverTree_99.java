package com.leetcode.hard;

/***二叉搜索树中的两个节点被错误地交换。
 请在不改变其结构的情况下，恢复这棵树。
 输入: [1,3,null,null,2]
 输出: [3,1,null,null,2]
 输入: [3,1,4,null,null,2]
 输出: [2,1,4,null,null,3]
 进阶:
 使用 O(n) 空间复杂度的解法很容易实现。
 你能想出一个只使用常数空间的解决方案吗？
 */
public class recoverTree_99 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    TreeNode p1 = null, p2 = null, pre = null;
    //pre为遍历的当前结点的前驱指针
    //p1为中序逆序的第一个位置
    //p2为中序逆序的最后一个位置
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null && pre.val > root.val) {
            if (p1 == null) p1 = pre;
            p2 = root;
        }
        pre = root;
        helper(root.right);
    }
}
