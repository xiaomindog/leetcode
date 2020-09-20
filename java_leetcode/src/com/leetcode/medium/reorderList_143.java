package com.leetcode.medium;

/***给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 示例1:
 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 示例 2:
 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 **/
public class reorderList_143 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = slow.next;
        while (fast != null) {
            if (fast.next == null) break;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode insert = reverse(slow.next);
        slow.next = null;
        ListNode p = head;
        while (p != null && insert != null) {
            ListNode r1 = p.next, r2 = insert.next;
            insert.next = p.next;
            p.next = insert;
            insert = r2;
            p = r1;
        }
    }

    public ListNode reverse(ListNode node) {
        ListNode head = new ListNode(-1);
        head.next = null;
        while (node != null) {
            ListNode r = node.next;
            node.next = head.next;
            head.next = node;
            node = r;
        }
        return head.next;
    }

}
