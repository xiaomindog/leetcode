package com.leetcode.medium;

//147. 对链表进行插入排序
public class insertionSortList_147 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode myHead = new ListNode(-1);
        myHead.next = head;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode r = p.next;
            //循环找到插入位置
            ListNode f = myHead;
            while (f.next != null && f.next.val < p.val) {
                f = f.next;
            }
            p.next = f.next;
            f.next = p;
            p = r;
        }
        return myHead.next;
    }
}
