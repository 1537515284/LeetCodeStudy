package linkList;

public class B奇偶链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1Node2 = new ListNode(2);
        ListNode l1Node3 = new ListNode(3);
        ListNode l1Node4 = new ListNode(4);
        ListNode l1Node5 = new ListNode(5);
        l1.next = l1Node2;
        l1Node2.next = l1Node3;
        l1Node3.next = l1Node4;
        l1Node4.next = l1Node5;

        ListNode node = oddEvenList(l1);
        ListNode.printNode(node);
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        //奇数链表的头节点
        ListNode oddHead = head;
        //奇数链表的当前节点
        ListNode oddCur = oddHead;

        //偶数链表的头节点
        ListNode evenHead = head.next;
        //偶数链表的当前节点
        ListNode evenCur = evenHead;


        while (evenCur != null && evenCur.next != null){
            //奇数节点串一起
            oddCur.next = oddCur.next.next;
            //偶数节点串一起
            evenCur.next = evenCur.next.next;
            //奇偶指针往后移
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        //最后偶数链表和奇数链表需要串在一起
        oddCur.next = evenHead;
        return oddHead;
    }
}
