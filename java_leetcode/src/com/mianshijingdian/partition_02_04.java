package com.mianshijingdian;

//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
// 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
// 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
//        示例:
//        输入: head = 3->5->8->5->10->2->1, x = 5
//        输出: 3->1->2->10->5->5->8

public class partition_02_04 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        //利用2个不同的头结点
        ListNode small = new ListNode(-1);
        ListNode tail = small;
        ListNode large = new ListNode(-2);
        large.next = null;
        while (head != null) {
            ListNode p = head; //取下head结点
            head = head.next; //head结点指向下一个结点
            if (p.val < x) {
                tail.next = p; //尾插法 tail保存small部分的为节点
                tail = p;
            } else {
                p.next = large.next; //头插法
                large.next = p;
            }
        }
        tail.next = large.next;
        return small.next;
    }
}
