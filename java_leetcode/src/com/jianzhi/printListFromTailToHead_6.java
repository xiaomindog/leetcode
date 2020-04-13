package com.jianzhi;

import java.util.ArrayList;



public class printListFromTailToHead_6 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode p = listNode;
        while (p!=null){
            arrayList.add(0,p.val);
            p=p.next;
        }
        return arrayList;
    }

}
