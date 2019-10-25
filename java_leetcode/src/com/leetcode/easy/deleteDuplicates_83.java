package com.leetcode.easy;
/*83. 删除排序链表中的重复元素*/

public class deleteDuplicates_83 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //非递归  遍历  带头结点
    public ListNode dDs01(ListNode head) {
        ListNode h = new ListNode(-1); //构造一个头结点
        h.next = head; //第一个结点
        ListNode p = h;
        ListNode q = h.next; //定义前后指针

        while(q!=null){
            if(q.val==p.val){
                q = q.next;
                p.next=q;
            }else{
                p=q;
                q=q.next;
            }
        }
        return h.next;
    }
     //不带头结点
    public ListNode dDs02(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(q!=null){
            if(q.val==p.val){
                q = q.next;
                p.next=q;
            }else{
                p=q;
                q=q.next;
            }
        }
        return head;
    }
    //递归方法
    public ListNode dDs03(ListNode head){
        if(head==null){
            return head;
        }
        if(head.next!=null && head.val==head.next.val){
            while(head.next!=null && head.val==head.next.val){
                head=head.next;
            }
            return dDs03(head);
        }else{
            head.next=dDs03(head.next);
            return head;
        }
    }

    public static void main(String[] args) {

    }

}

