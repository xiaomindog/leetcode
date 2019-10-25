package com.leetcode.easy;

public class isPalindrome_234 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //回文链表 t-o(n)k-o(1)
    public static boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        ListNode ph = new ListNode(-1);//作为前半部分的头结点
        ph.next = null;
        ListNode h;
        int count = 0;

        while (count < len / 2) {
            count++;
            h = head;
            head = head.next;
            h.next = ph.next;
            ph.next = h; //头插法
        }
        if (len % 2 == 1) head = head.next; //如果长度为奇数 最中间的那个就不需要比较
        while (head != null && ph.next != null) {
            if (head.val != ph.next.val)
                return false;
            head = head.next;
            ph = ph.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode t = new ListNode(0);
        ListNode tn = new ListNode(0);

        tn.next = null;
        t.next = tn;
        boolean f = isPalindrome(t);
        System.out.println(f);
    }
}
