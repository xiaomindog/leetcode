package com.jianzhi;


//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
public class reverseList_24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = new ListNode(-1);
        pre.next = null;
        ListNode p, pNext;
        p = head;
        while (p != null) {
            pNext = p.next;
            p.next = pre.next;
            pre.next = p; //头插法
            p = pNext;
        }
        return pre.next;
    }

}
