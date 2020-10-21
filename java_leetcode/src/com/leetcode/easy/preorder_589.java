package com.leetcode.easy;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

//给定一个 N 叉树，返回其节点值的前序遍历。
public class preorder_589 {
    public class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //递归
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder_1(Node root) {
        if (root == null) return ans;
        ans.add(root.val);
        List<Node> temp = root.children;
        if (temp.size() != 0) {
            for (int i = 0; i < temp.size(); i++) {
                preorder_1(temp.get(i));
            }
        }
        return ans;
    }


    //迭代
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            res.add(p.val);
            if (p.children.size() != 0) {
                for (int i = p.children.size() - 1; i >= 0; i--) {
                    stack.push(p.children.get(i)); //在头部插入
                }
            }
        }
        return res;
    }

}







