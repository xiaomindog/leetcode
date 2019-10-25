package com.leetcode.easy;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class hasCycle_141 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        //快慢指针 slow每次走1格 fast每次走2格
        if (head == null) return false;
        ListNode slow = head;
        if (slow.next == null) return false;
        ListNode fast = slow.next.next;

        while (fast != null) {
            if (slow == fast) return true;  //当快慢指针相遇 说明存在环
            else {
                slow = slow.next;
                if (fast.next == null) return false;
                fast = fast.next.next;
            }
        }
        //没有环的最终会推出循环
        return false;
    }

    // 借用哈希表 存储
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> hs = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (hs.add(p)) {
                p = p.next;
            } else {
                return true;
            }
        }
        return false;
    }

    //参考题解 倒置链表 没遍历一个结点 倒置它 如果最后能回到head结点 说明存在环  缺点 破坏了原链表
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode h = head;
        ListNode p = h.next;//p
        if (p == head) return true;
        if (p.next == null) return false;
        ListNode r = p.next; //到这一步 至少有3个结点
        while (r != null) {
            if (r == head) return true;
            r = p.next;
            p.next = h;
            h = p;
            p = r;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode s = new ListNode(-1);
        ListNode k = s.next;
        System.out.println(k);
    }
}
