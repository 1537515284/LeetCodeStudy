package level01.fourthDay;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class 环形链表Ⅱ142 {

    public static void main(String[] args) {
        ListNode bNode1 = new ListNode(3);
        ListNode bNode2 = new ListNode(2);
        ListNode bNode3 = new ListNode(0);
        ListNode bNode4 = new ListNode(-4);
//        ListNode bNode5 = new ListNode(5);
        bNode1.next = bNode2;
        bNode2.next = bNode3;
        bNode3.next = bNode4;
        bNode4.next = bNode2;
//        bNode4.next = bNode5;

        ListNode listNode = detectCycle(bNode1);
        System.out.println(listNode);

    }

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(!set.add(head))
                return head;
            head = head.next;
        }
        return null;
    }
}
