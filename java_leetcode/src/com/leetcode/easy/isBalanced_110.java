package com.leetcode.easy;

public class isBalanced_110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //暴力递归  时间复杂度 o(n^2)
    public boolean isBalanced_01(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(hight(root.left)-hight(root.right))<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        return false;
    }
    public int hight(TreeNode t){
        if(t==null){
            return 0;
        }
        return Math.max(hight(t.left),hight(t.right))+1;
    }
    //DFS  最差o(n)
    public boolean isBalanced(TreeNode root) {
        return DFS(root)!=-1;
    }
    public int DFS(TreeNode t){
        if(t==null) return 0;
        int left = DFS(t.left);
        if(left==-1) return -1; //剪枝
        int right = DFS(t.right);
        if(right==-1) return -1;
        return Math.abs(left-right)<=1?Math.max(left,right)+1:-1;
    }
}
