package com.ls.linkedList;

import java.util.List;
import java.util.Stack;

public class E回文链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 通过快慢指针找到中点
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果fast不为空，说明链表的长度是奇数个
        if(fast != null)
            slow = slow.next;
        // 反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null){
            // 然后比较，判断节点值是否相等
            if(fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    // 反转链表
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 栈 优化，不必全部比较
    public static boolean isPalindrome2(ListNode head) {
        if(head == null)
            return true;
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        // 链表的长度
        int len = 0;
        // 把链表节点的值存放到栈中
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
            len++;
        }
        // len长度除以2
        len >>= 1;
        // 然后再出栈
        while (len-- >= 0){
            if(head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }



}
