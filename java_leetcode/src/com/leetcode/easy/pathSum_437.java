package com.leetcode.easy;
/*给定一个二叉树，它的每个结点都存放着一个整数值。
找出路径和等于给定数值的路径总数。
路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。*/

public class pathSum_437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //思路1 双重递归
    //先序遍历每一个结点，在以每一个节点作为起始节点递归查找，  时间复杂度高，有很多重复的操作
    private int num = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        cal_sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return num;

    }

    public void cal_sum(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) {
            num++;
        }
        cal_sum(root.left, sum);
        cal_sum(root.right, sum);
    }

    //思路2
    /*核心：每个节点到根节点的路径是唯一的
     * 1.用一维数组保存当前节点到根节点的所有路径
     * 2.用一个标记表示当前路径的终点
     * 3.先序遍历所有节点
     * */
    public int pathSum_2(TreeNode root, int sum) {
        return cal_sum_2(root, sum, new int[1000], 0);
    }

    public int cal_sum_2(TreeNode root, int sum, int arry[], int p) {


        if (root == null) return 0;
        int n = (root.val == sum ? 1 : 0);
        int cur = root.val;
        for (int i = p - 1; i >= 0; i--) {
            cur += arry[i];
            if (cur == sum) {
                n++;
            }
        }
        arry[p] = root.val;
        int n1 = cal_sum_2(root.left, sum, arry, p + 1);
        int n2 = cal_sum_2(root.right, sum, arry, p + 1);
        return n + n1 + n2;
    }
}
