package com.leetcode.medium;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class swapPairs_24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归的思路
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    //迭代的方法
    public ListNode swapPairs_1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1); //尾插法 头结点
        newHead.next = null; //尾部置空
        ListNode p = head, q = head.next, r = q.next, newR = newHead;
        while (q != null) {
            p.next = newR.next;
            q.next = p;
            newR.next = q;
            newR = p;
            p = r;
            if (r != null && r.next != null) {
                q = r.next;
                r = q.next;
            } else {
                break;
            }
        }
        if (p != null) { //节点个数为奇数
            p.next = newR.next;
            newR.next = p;
        }
        return newHead.next;
    }
}
