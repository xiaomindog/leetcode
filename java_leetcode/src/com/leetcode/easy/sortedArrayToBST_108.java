package com.leetcode.easy;

public class sortedArrayToBST_108 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sATB(nums,0,nums.length);
    }

    public static TreeNode sATB(int[] nums,int i,int j){
        if(i==j){
            return null;
        }
        int mid = (i+j)/2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = sATB(nums,i,mid);
        t.right = sATB(nums,mid+1,j);
        return t;
    }

    public static void main(String[] args) {

    }

}
