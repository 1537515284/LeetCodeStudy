package level01.thirdDay;

public class 反转链表206 {

    public static void main(String[] args) {
        ListNode bNode1 = new ListNode(1);
        ListNode bNode2 = new ListNode(2);
        ListNode bNode3 = new ListNode(3);
        ListNode bNode4 = new ListNode(4);
        ListNode bNode5 = new ListNode(5);
        bNode1.next = bNode2;
        bNode2.next = bNode3;
        bNode3.next = bNode4;
        bNode4.next = bNode5;

        ListNode listNode = reverseList(bNode1);
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode temp = head;
        while (temp != null){
            ListNode next = temp.next;
            temp.next = res;
            res = temp;
            temp = next;
        }
        return res;
    }
}
