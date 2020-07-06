package com.jianzhi;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

public class levelOrder_32_III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, ans, 0);
        return ans;
    }

    public void bfs(TreeNode root, List<List<Integer>> ans, int level) {
        if(root==null) return;
        if (ans.size()<=level ) {
            List<Integer> t = new ArrayList<>();
            ans.add(t);
        }
        if (level % 2 == 0) ans.get(level).add(root.val);
        else ans.get(level).add(0, root.val);
        bfs(root.left, ans, level + 1);
        bfs(root.right, ans, level + 1);
    }


}
