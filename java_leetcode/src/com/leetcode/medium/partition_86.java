package com.leetcode.medium;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class partition_86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);//保存小于部分的结点
        ListNode head2 = new ListNode(1);
        head1.next = null;
        head2.next = null;
        ListNode h1 = head1, h2 = head2, p;
        while (head != null) {
            p = head; //取下该结点
            head = head.next;
            if (p.val < x) {
                p.next = h1.next;
                h1.next = p;
                h1 = p;
            } else {
                p.next = h2.next;
                h2.next = p;
                h2 = p;
            }
        }
        h1.next = head2.next; //接上2个链表
        return head1.next;
    }
}
