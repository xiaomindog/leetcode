package com.mianshijingdian;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 */

public class addTwoNumbers_02_05 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;//进位标记
        ListNode head = new ListNode(-1), p;
        p = head;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode((l1.val + l2.val + flag) % 10);
            flag = (l1.val + l2.val + flag) / 10;
            p.next = node;
            p = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ListNode node = new ListNode((l1.val + flag) % 10);
            flag = (l1.val + flag) / 10;
            p.next = node;
            p = node;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode node = new ListNode((l2.val + flag) % 10);
            flag = (l2.val + flag) / 10;
            p.next = node;
            p = node;
            l2 = l2.next;
        }
        if (flag == 0) {
            p.next = null;
        } else {
            ListNode node = new ListNode(flag);
            p.next = node;
            node.next = null;
        }
        return head.next;
    }
}
