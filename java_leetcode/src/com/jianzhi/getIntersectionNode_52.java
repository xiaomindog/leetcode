package com.jianzhi;

//输入两个链表，找出它们的第一个公共节点。
public class getIntersectionNode_52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode pa = headA, pb = headB;
        while (pa != null) {
            pa = pa.next;
            lenA++;
        }
        while (pb != null) {
            pb = pb.next;
            lenB++;
        }
        if (lenA > lenB) {
            int cha = lenA - lenB;
            while (cha > 0) {
                headA = headA.next;
                cha--;
            }
        } else {
            int cha = lenB - lenA;
            while (cha > 0) {
                headB = headB.next;
                cha--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
