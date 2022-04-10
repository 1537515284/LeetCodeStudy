package com.ls.linkedList;


import java.util.HashSet;
import java.util.Set;

public class F环形链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        boolean hasCycle = hasCycle3(node1);
        System.out.println(hasCycle);
    }

    // 快慢指针
    public static boolean hasCycle(ListNode head){
        if(head == null)
            return false;
        // 快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            // 慢指针每次走一步
            slow = slow.next;
            // 快指针每次走两步
            fast = fast.next.next;
            // 如果相遇，说明有环，直接返回true
            if(slow == fast)
                return true;
        }
        // 否则就是没环
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            // 如果重复出现说明有环
            if(set.contains(head))
                return true;
            //否则就把当前节点加入到集合中
            set.add(head);
            head = head.next;
        }
        return false;
    }

    // 逐个删除
    public static boolean hasCycle3(ListNode head){
        // 如果head为空，或者他的next指向为空，直接返回false
        if(head == null || head.next == null)
            return false;
        // 如果出现head.next = head 表示有环
        if(head.next == head)
            return true;
        ListNode nextNode = head.next;
        // 当前节点的next指向他自己，相当于把它删除了
        head.next = head;
        // 然后递归，查看下一个节点
        return hasCycle3(nextNode);
    }
}
