package com.ls.linkedList;

public class A删除链表中的节点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        traverse(node1);
        deleteNode(node2);
        System.out.println("删除后......");
        traverse(node1);
    }


    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public static void traverse(ListNode node){
        while (node != null){
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }
}

