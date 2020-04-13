package com.leetcode.medium;

/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
并且它们的每个节点只能存储一位数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/

public class addTwoNumbers_2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //思路
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);//头结点
        head.next = null;
        ListNode p = head; //移动指针 尾插
        ListNode pl1 = l1;
        ListNode pl2 = l2;
        int flag = 0;//进位标志
        while (pl1 != null || pl2 != null) {
            int x1 = pl1 == null ? 0 : pl1.val;
            int x2 = pl2 == null ? 0 : pl2.val;

            int sum = x1 + x2 + flag;
            ListNode node;
            if (sum < 10) {
                node = new ListNode(sum);
            } else {
                node = new ListNode(sum % 10);
            }
            flag = sum / 10;
            node.next = p.next;
            p.next = node;
            p = node;
            if (pl1 != null) pl1 = pl1.next;
            if (pl2 != null) pl2 = pl2.next;
        }
        if (flag != 0) {
            ListNode node = new ListNode(flag);
            node.next = null;
            p.next = node;
        }

        return head.next;

    }


//    public ListNode reverseList(ListNode node) {
//        if (node == null || node.next == null) return node;
//        ListNode head = new ListNode(0);
//        head.next = null;
//
//        ListNode p = node;
//        ListNode pNext = null;
//
//        while (p != null) {
//            pNext = p.next;
//            p.next = head.next;
//            head.next = p; //头插法
//            p = pNext;
//
//        }
//        return head.next;
//
//    }
}
