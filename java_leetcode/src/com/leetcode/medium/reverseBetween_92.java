package com.leetcode.medium;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤m≤n≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseBetween_92 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归思路
    ListNode successor = null; // 后驱节点 作为第N+1个结点（第n个结点的后驱结点）
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next; //这一步是很必要的
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) return reverseN(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1); //m-1 n-1是因为一次摘掉前面的结点
        return head;
    }


    public ListNode reverseBetween_1(ListNode head, int m, int n) {
        if (m >= n || head == null) return head;
        ListNode myHead = new ListNode(-1);
        ListNode hp = myHead; //myhead的尾指针
        ListNode p = head; //原链表的移动指针
        int i = 1;
        while (i < m && p != null) {
            hp.next = p;
            p = p.next;
            //hp.next.next = null;
            hp = hp.next;
            i++;
        }
        i = m;
        if (p == null) {
            hp.next = null;
            return myHead.next;
        }

        ListNode r = p; //记录倒置的尾结点
        boolean flag = true;
        while (i <= n && p != null) {
            if (flag) {
                r = p;
                flag = false;
            }
            ListNode t = p.next;//暂存p的下一个结点
            p.next = hp.next;
            hp.next = p;
            p = t;
            i++;
        }
        r.next = p;
        return myHead.next;
    }
}
