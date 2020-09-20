package com.leetcode.medium;

/**
 * 在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class sortList_148 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //迭代 空间复杂度O(1)  字节面试题
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }


        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        for (int e = 1; e < length; e *= 2) {
            ListNode cur = dummyHead.next; //待合并的结点的第一个结点
            ListNode tail = dummyHead; //已经合并好的结点的最后一个结点
            while (cur != null) {
                ListNode left = cur; // 归并的左部分
                ListNode right = cut(left, e);//右部分的第一个结点
                cur = cut(right, e); //cur继续指向剩下的部分
                tail.next = merge(left, right); //left和right各自有序 归并
                // 并采用尾插法插入到尾结点后形成完整链表
                while (tail.next != null) {
                    tail = tail.next;
                }

            }

        }


        return dummyHead.next;
    }

    //摘下链表的前n个结点，返回第n+1个结点（单独一个结点）
    public ListNode cut(ListNode node, int n) {
        while (n > 1 && node != null) {
            node = node.next;
            n--;
        }
        if (node == null) return null;
        ListNode next = node.next;
        node.next = null;
        return next;
    }

    //归并 有序
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return head.next;
    }


    //递归空间复杂度O(logn)
    public ListNode sortList_1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList_1(head);
        ListNode right = sortList_1(temp);

        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left != null) {
            p.next = left;
        } else {
            p.next = right;
        }
        return dummyHead.next;
    }
}
