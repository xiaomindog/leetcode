package com.leetcode.easy;

public class isSameTree_100 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
             val = x;
         }
     }
    //相同的树
    public boolean iST(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        if(p!=null&&q!=null&&q.val==p.val)
        {
            return iST(p.left,q.left)&&iST(p.right,q.right);
        }
        return false;
    }
}
