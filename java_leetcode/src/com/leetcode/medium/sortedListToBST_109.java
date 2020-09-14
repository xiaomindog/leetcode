package com.leetcode.medium;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 **/
public class sortedListToBST_109 {
    public class TreeNode {
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //直接在原链表上操作  分解成2个链表
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode fast = head, slow = head, pre = head;
        while (fast != null) {
            if (fast.next == null) break;
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;

        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        TreeNode left = sortedListToBST_1(head);
        TreeNode right = sortedListToBST(slow.next);
        root.left = left;
        root.right = right;
        return root;
    }


    //借用数组
    public TreeNode sortedListToBST_1(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int[] nums = new int[len];
        p = head;
        int i = 0;
        while (p != null) {
            nums[i++] = p.val;
            p = p.next;
        }
        return change(nums, 0, nums.length - 1);
    }

    public TreeNode change(int[] nums, int i, int j) {
        if (i > j) return null;
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = change(nums, i, mid - 1);
        TreeNode right = change(nums, mid + 1, j);
        root.left = left;
        root.right = right;
        return root;
    }
}
