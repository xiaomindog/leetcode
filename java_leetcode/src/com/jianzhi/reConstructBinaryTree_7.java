package com.jianzhi;

/*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
则重建二叉树并返回。*/
public class reConstructBinaryTree_7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) return null;
        TreeNode tree = reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return tree;
    }

    public TreeNode reConstruct(int[] pre, int pl, int pr, int[] in, int il, int ir) {

        if (pl > pr || il > ir) {
            return null;
        }
        TreeNode tree = new TreeNode(pre[pl]);
        for (int i = il; i <= ir; i++) {
            if (in[i] == pre[pl]) {
                tree.left = reConstruct(pre, pl + 1, pl + i - il, in, il, i - 1);
                tree.right = reConstruct(pre, pl + 1 + i - il, pr, in, i + 1, ir);
                break;
            }
        }
        return tree;
    }

}
