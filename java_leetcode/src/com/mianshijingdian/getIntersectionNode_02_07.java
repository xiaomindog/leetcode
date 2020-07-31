package com.mianshijingdian;

public class getIntersectionNode_02_07 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //双指针解法  很骚的思路
    //    设链表A的长度为a，链表B的长度为b，A到相交结点的距离为c,B到相交节点的距离为d，
    //    显然可以得到两者相交链表的长度：a - c = b - d，
    //    变换一下式子得到:a + d = b + c
    //    我们用一个指针从链表A出发，到末尾后就从B出发，
    //    用另一个指针从B出发，到末尾后从A出发，由于上面的公式，
    //    当前一个指针走了a+d步数时，后一个指针走了b+c,两步数相等，即走到了相交节点。
    //    链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/solution/
    //    chao-jian-dan-zheng-ming-shuang-zhi-zhen-de-zheng-/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode q = headA, p = headB;
        while (q != p) {
            if (q != null) {
                q = q.next;
            } else {
                q = headB;
            }
            if (p != null) {
                p = p.next;
            } else {
                p = headA;
            }
        }
        return q;
    }


    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        int lena = 0, lenb = 0;
        ListNode ha = headA, hb = headB;
        ListNode p = ha;
        while (p != null) {
            lena++;
            p = p.next;
        }
        p = hb;
        while (p != null) {
            lenb++;
            p = p.next;
        }
        if (lena > lenb) {
            int cha = lena - lenb;
            while (cha > 0) {
                ha = ha.next;
                cha--;
            }
        } else {
            int cha = lenb - lena;
            while (cha > 0) {
                hb = hb.next;
                cha--;
            }
        }

        while (ha != null && hb != null) {
            if (ha == hb) return ha;
            ha = ha.next;
            hb = hb.next;
        }
        return null;
    }
}
