package com.ls.design;

public class B最小栈 {
}


class MinStack {

    // 链表头，相当于栈顶
    private ListNode head;

    //压栈，需要判断栈是否为空
    public void push(int val) {
        if(empty())
            head = new ListNode(val,val,null);
        else
            head = new ListNode(val,Math.min(val,head.min),head);
    }

    //出栈，相当于把链表头删除
    public void pop() {
        if(empty())
            throw new IllegalStateException("栈为空......");
        head = head.next;
    }

    //栈顶的值也就是链表头的值
    public int top() {
        if(empty())
            throw new IllegalStateException("栈为空......");
        return head.val;
    }

    //链表中头结点保存的是整个链表最小的值，所以返回head.min也就是
    //相当于返回栈中最小的值
    public int getMin() {
        if(empty())
            throw new IllegalStateException("栈为空......");
        return head.min;
    }

    // 判断栈是否为空
    public boolean empty(){
        return head == null;
    }
}

class ListNode {
    public int val;
    public int min; // 最小值
    public ListNode next;

    public ListNode(int val,int min,ListNode next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
