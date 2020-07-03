package com.jianzhi;

public class mergeTwoLists_25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }
}
