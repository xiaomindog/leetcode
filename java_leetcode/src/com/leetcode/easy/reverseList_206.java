package com.leetcode.easy;

public class reverseList_206 {

    public  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //不带头节点  头插法
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode h = new ListNode(-1);
        h.next = head;  //创建一个头结点
        ListNode p = h.next;
        h.next = null;
        while (p != null) {
            ListNode r = p;
            p = p.next;
            r.next = h.next;
            h.next = r; //头插
        }
        return h.next;
    }

    //递归反转
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;  //这一步中隐含了接链的操作
        head.next = null; //这2步相当于反转了一个结点之后去掉一个结点  就是把head的上一个结点作为下一次的head
        return p;
    }


}
