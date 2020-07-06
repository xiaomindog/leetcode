package com.jianzhi;


import java.util.LinkedList;
import java.util.Stack;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
// 如果是则返回 true，否则返回 false。
// 假设输入的数组的任意两个数字都互不相同。
public class verifyPostorder_33 {

    //后序遍历 左右根 递归
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) return true;
        return verify(postorder, 0, postorder.length - 1);

    }

    public boolean verify(int[] postorder, int l, int r) {
        if (l >= r) return true;
        int p = l;
        while (postorder[p] < postorder[r]) p++; //找出左子树的全部结点
        // 左子树所有节点必定满足都小于根节点
        int m = p; //保存右子树的左边界
        while (postorder[p] > postorder[r]) p++;// // 右子树所有节点必定满足大于根节点
        if (p != r) return false;
        return verify(postorder, l, m - 1) && verify(postorder, m, r - 1);

    }

    public boolean verifyPostorder_2(int[] postorder) {
        if (postorder.length <= 1) return true;
        Stack<Integer> stack = new Stack<>(); //单调栈
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            //如果左节点的值大于根结点 不满足二叉搜索树的性质
            while (!stack.empty() && stack.peek() > postorder[i]) {
                //如果当前的栈顶元素大于遍历的元素 说明已经走到了左子树
                root = stack.pop(); //根节点变为现在的栈顶元素
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
