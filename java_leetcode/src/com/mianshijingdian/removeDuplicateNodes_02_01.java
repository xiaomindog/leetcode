package com.mianshijingdian;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * 示例1:
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 */
public class removeDuplicateNodes_02_01 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //利用两层循环
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode p = head;
        ListNode qre, q;
        while (p != null) {
            qre = p;
            q = p.next;
            while (q != null) {
                if (q.val != p.val) {
                    qre = q;
                    q = q.next;
                } else {
                    qre.next = q.next;
                    q = q.next;
                }
            }
            p = p.next;
        }
        return head;
    }

    //利用set保存出现过的val
    public ListNode removeDuplicateNodes_1(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode pre = new ListNode(-1), p = head;
        pre.next = head;
        while (p != null) {
            if (!set.contains(p.val)) {
                set.add(p.val);
                pre = p;
                p = p.next;
            } else {
                pre.next = p.next;
                p = p.next;
            }
        }
        return head;
    }
}
