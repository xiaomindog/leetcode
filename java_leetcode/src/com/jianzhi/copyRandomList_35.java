package com.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 */


public class copyRandomList_35 {
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //原地修改//三步走
    //第一步 复制原来的结点到每个结点的下一个结点的位置
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node p = head;
        //将每个结点复制一遍
        while (p != null) {
            Node pNext = new Node(p.val);
            pNext.next = p.next;
            p.next = pNext;
            p = pNext.next;
        }
        //修改random的指针结点指向到拷贝的结点
        p = head;
        while (p != null) {
            if (p.random != null) {  //如果拷贝前的结点random指针不为空
                // 则将拷贝后的结点的random的指针置为原来random指针的下一个结点
                p.next.random = p.random.next;
            } else {
                p.next.random = null;
            }
            p = p.next.next;
        }
        //把拷贝的结点取出来
        Node newHead = new Node(-1);//头结点
        Node newp = newHead;//拷贝的移动指针
        p = head;
        while (p != null) {
            newp.next = p.next; //拷贝的结点指向他的下一个
            newp = newp.next;
            p.next = p.next.next; //相当于去掉拷贝结点
            p = p.next;
        }
        return newHead.next;//返回头结点的下一个
    }


    //借用哈希表 空间复杂度O(n)
    public Node copyRandomList_2(Node head) {
        Map<Node, Node> map = new HashMap<>();
        //map中存的是(原节点，拷贝节点)
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        //生成拷贝链表
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
