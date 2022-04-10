package com.ls.linkedList;

public class D合并两个有序链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode mergeNode = mergeTwoLists2(node1, node4);
        ListNode.traverse(mergeNode);


    }

    // 遍历
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 判断为空的情况
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2!=null){
            // 比较一下，哪个小就把哪个放到新的链表中
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        // 然后把哪个不为空的链表挂到新的链表中
        curr.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    // 递归
    public static ListNode mergeTwoLists2(ListNode list1,ListNode list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val < list2.val){
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }
    }


    // 递归改进，可读性不好
    public static ListNode mergeTwoLists3(ListNode list1,ListNode list2){
        // 只要有一个为空，就返回另一个
        if(list1 == null || list2 == null)
            return list2 == null ? list1 : list2;
        // 把小的赋值给first
        ListNode first = (list2.val < list1.val) ? list2 : list1;
        first.next = mergeTwoLists3(first.next,first == list1 ? list2 : list1);
        return first;
    }
}
