package com.ls.linkedList;

public class B删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode listNode = removeNthFromEnd2(node1, 2);
        traverse(listNode);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int last = length(head) - n;
        if(last == 0)
            return head.next;
        for (int i = 0; i < last-1; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    private static int length(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public static ListNode removeNthFromEnd2(ListNode head,int n){
        ListNode fast = head;
        ListNode slow = head;
        // fast移动n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 如果fast为空，表示删除的是头结点
        if(fast == null)
            return head.next;

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 这里最终slow不是倒数第n个节点，他是倒数第n+1节点
        // 他的下一个结点是倒数第n个节点，所以删除的是他下一个节点
        slow.next = slow.next.next;
        return head;
    }

    public static void traverse(ListNode node){
        while (node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }
}
