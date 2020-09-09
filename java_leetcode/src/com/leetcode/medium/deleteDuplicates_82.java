package com.leetcode.medium;

import java.util.List;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class deleteDuplicates_82 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //链表的递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        int t = head.val;
        while (head != null && head.val == t) {
            head = head.next;
        }
        return deleteDuplicates(head);
    }


    //尾插法
    public ListNode deleteDuplicates_1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode myHead = new ListNode(-1);
        ListNode p = head, q = myHead, r;//p为移动指针,q为myHead的尾指针，r用来暂存p的后继结点
        while (p != null) {
            if (p.next == null || p.next.val != p.val) { //如果只剩一个结点 直接加入 不会重复
                r = p.next;
                p.next = null; //这2行是为了摘下p结点待加入到myHead中
                q.next = p;
                q = p;
                p = r;
            } else {
                int t = p.val;
                while (p != null && p.val == t) {
                    p = p.next;
                }
            }
        }
        q.next = null;//保证尾指针为空
        return myHead.next;
    }
}
