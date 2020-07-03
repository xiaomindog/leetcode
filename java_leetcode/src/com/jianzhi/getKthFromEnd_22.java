package com.jianzhi;

public class getKthFromEnd_22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode low, fast = new ListNode(-1);
        low = head;
        fast = head;
        if (fast == null) return null;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
