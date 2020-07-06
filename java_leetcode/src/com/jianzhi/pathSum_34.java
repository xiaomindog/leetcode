package com.jianzhi;

import java.util.ArrayList;
import java.util.List;

public class pathSum_34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arry = new ArrayList<>();
        dfs(root, sum, arry, ans);
        return ans;
    }

    public void dfs(TreeNode root, int sum, List<Integer> arry, List<List<Integer>> ans) {
        if (root == null) return;
        arry.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            //ans.add(arry); //整个递归过程用的是同一个arry，需要把当前的状态保存下来，否则最后的输出全为空[]
            ans.add(new ArrayList<>(arry));
        }
        dfs(root.left, sum, arry, ans);
        dfs(root.right, sum, arry, ans);
        arry.remove(arry.size() - 1);
    }
}
