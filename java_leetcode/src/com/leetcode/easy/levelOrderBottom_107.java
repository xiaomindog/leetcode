package com.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrderBottom_107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    //广度优先
    public void DFS(TreeNode p,int level,List<List<Integer>> ans){
        if(p==null){
            return;
        }
        if(ans.size()<=level){
            List<Integer> t = new ArrayList<>();
            ans.add(0,t); //相当于头插
        }
        ans.get(ans.size()-1-level).add(p.val);
        DFS(p.left,level+1,ans);
        DFS(p.right,level+1,ans);
    }
    public List<List<Integer>> lOB(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root,0,ans);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(1);
    }
}
