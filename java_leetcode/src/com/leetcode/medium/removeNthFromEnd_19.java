package com.leetcode.medium;


//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
public class removeNthFromEnd_19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //双指针 基础题
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建一个头结点 方便处理第一个结点
        ListNode HEAD = new ListNode(-1);
        HEAD.next=head;
        ListNode p = HEAD, q = HEAD;
        while (n >= 0) {
            n--;
            p = p.next;
        }
        while (p != null) {
            q = q.next;
            p = p.next;
        }

        q.next = q.next.next;

        return HEAD.next;
    }
}
