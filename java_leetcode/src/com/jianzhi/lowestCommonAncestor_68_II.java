package com.jianzhi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//二叉树的最近公共祖先 mid

public class lowestCommonAncestor_68_II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //法1：递归 由于需要先知道左右子树的情况，然后决定向上返回什么。因此「后序遍历」的思想是很关键
    //考虑通过递归对二叉树进行后序遍历，当遇到节点p或q时返回。从底至顶回溯，
    // 当节点p,q 在节点root的异侧时，节点 root即为最近公共祖先，则向上返回 root。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);  //在左子树找p,q
        TreeNode right = lowestCommonAncestor(root.right, p, q);//在右子树找p,q
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    //法2：
    //利用哈希表 存储每个结点的父节点
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        dfs(root);
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parent.get(p); //p结点的所有父节点保存到集合去（包括本身）
        }
        while (q != null) {
            if (set.contains(q)) { //如果第一次遇到相同的父节点，即为最近的公共祖先
                return q;
            }
            q = parent.get(q);
        }
        return null;
    }
}
