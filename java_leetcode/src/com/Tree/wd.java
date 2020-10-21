package com.Tree;

import java.util.ArrayList;
import java.util.List;

public class wd {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //1）统计度为1的结点个数：
    int get_degree1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        if (root.left == null) return 1 + get_degree1(root.right);
        if (root.right == null) return 1 + get_degree1(root.left);
        return get_degree1(root.left) + get_degree1(root.right);
    }

    //2)统计度为2的结点个数
    int get_degree2(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return 1 + get_degree2(root.left) + get_degree2(root.right);
        }
        return get_degree2(root.left) + get_degree2(root.right);
    }

    // 3)统计度为0的结点个数
    int get_degree0(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return get_degree0(root.left) + get_degree0(root.right);
    }

    // 4)统计二叉树的高度
    int getHight(TreeNode root) {
        if (root == null) return 0;
        int leftHight = getHight(root.left);
        int rightHight = getHight(root.right);
        return Math.max(leftHight, rightHight) + 1;
    }

    //5)统计二叉树的宽度
    //这道题涉及较难，可不考虑
    /*求出二叉树的最大宽度，可以将每一个节点按层序标记序号mark
    需要记录每一行的第一个第一个节点的序号，然后在遍历本层其他每一个节点的时候
    比较与本层第一个节点的序号差值，并取最大值 */
    int[] left = new int[2000]; //用来存储每一层最左边的结点
    int i = 0;
    int max = 1;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0, 1);
        return max;
    }

    void dfs(TreeNode root, int level, int index) {
        if (root == null) return;
        if (level == i) {
            left[i++] = index;
        }
        max = Math.max(max, index + 1 - left[level]);
        dfs(root.left, level + 1, 2 * index);
        dfs(root.right, level + 1, 2 * index + 1);
    }

    //6）从二叉树中删除所有叶子结点
    void del_leaf(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) root = null;

        if (root.left != null) {
            del_leaf(root.left);
        }
        if (root.right != null) {
            del_leaf(root.right);
        }
    }

    //7)计算指定结点P所在的层次
    int getLevel(TreeNode root, TreeNode p) {
        return level(root, p, 1); //调用下面这个函数
    }

    int level(TreeNode root, TreeNode p, int n) {
        if (root == null) return 0; //如果root为空，返回0
        if (root == p) return n; //如果root等于p，返回1 根节点层次即是其所在的层次
        int l = level(root.left, p, n + 1);
        if (l != 0) return l;
        return level(root.right, p, n + 1);
    }

    //8）计算二叉树中各个结点最大的元素的值
    int max_value = Integer.MIN_VALUE;

    int getMaxValue(TreeNode root) {
        getMax(root);
        return max_value;
    }

    void getMax(TreeNode root) {
        if (root == null) return;
        getMax(root.left);
        getMax(root.right);
        if (root.val > max_value) max_value = root.val;
    }

    //法2
    int get_max(TreeNode root, int m) { //m初始设为Integer.MIN_VALUE
        if (root == null) return Integer.MIN_VALUE;
        if (root.val > m) m = root.val;
        int lm = get_max(root.left, m);
        int rm = get_max(root.right, m);
        return Math.max(lm, rm);
    }


    //9）交换二叉树中每个结点的2个子女
    void swap(TreeNode root) {
        //后续遍历
        if (root == null) return;
        swap(root.left);
        swap(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //10) 先序输出所有结点即其所在层次
    void pre_print(TreeNode root, int level) { //level初始为1
        System.out.println(root.val + " " + level);
        pre_print(root.left, level + 1);
        pre_print(root.right, level + 1);
    }
}
