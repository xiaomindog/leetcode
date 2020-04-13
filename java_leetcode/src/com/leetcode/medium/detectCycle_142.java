package com.leetcode.medium;
/*给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。*/

import com.leetcode.easy.hasCycle_141;

import java.util.HashSet;
import java.util.Set;

public class detectCycle_142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //快慢指针 时间复杂度n 空间1
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (true) {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
            if (slow == fast) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    //借助哈希表的方法   n n
    public ListNode detectCycle_2(ListNode head) {
        Set<ListNode> hs = new HashSet<>();

        ListNode p = head;
        while (p != null) {
            if (hs.add(p)) {
                p = p.next;
            } else {
                return p;
            }
        }
        return null;
    }
}
