package com.jianzhi;


//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//返回删除后的链表的头节点。

public class deleteNode_18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre, q = new ListNode(-1);
        q.next = head;
        pre = q;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                return q.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return null;
    }

    //

    // 分析一下时间复杂度：
    //总的时间复杂度[O(1)*(n-1)+O(n)]/n = O(1)
    public ListNode deleteNode_2(ListNode head, ListNode val) {
        if (head == null | val == null) return null;
        if (val.next != null) {
            //如果val的下一个节点不为空
            ListNode valNext = val.next;
            val.next = valNext.next;
            val.val = valNext.val; //用val的下一个节点来覆盖val结点
            return head;
        } else if (head == val) {
            return null; //如果只有一个节点并且该节点是要删除的点
        } else {
            //如果要删除的点是最后一个节点
            ListNode p = head;
            while (p.next != val) {
                p = p.next;
            }
            p.next = null;
            return head;
        }
    }
}
