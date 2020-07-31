package com.mianshijingdian;

public class isPalindrome_02_06 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //编写一个函数，检查输入的链表是否是回文的。
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        ListNode q = new ListNode(-1);  //前半部分结点的头结点  采用头插法
        q.next = null;
        int i = 0;
        while (i < len / 2) {
            ListNode t = p;
            p = p.next;
            t.next = q.next;
            q.next = t;
            i++;
        }
        if (len % 2 != 0) {
            p = p.next;
        }
        q = q.next;
        while (p != null) {
            if (q.val != p.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
