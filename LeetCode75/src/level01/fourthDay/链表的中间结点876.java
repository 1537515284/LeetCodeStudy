package level01.fourthDay;

@SuppressWarnings({"all"})
public class 链表的中间结点876 {

    public static void main(String[] args) {
        ListNode bNode1 = new ListNode(1);
        ListNode bNode2 = new ListNode(2);
        ListNode bNode3 = new ListNode(3);
        ListNode bNode4 = new ListNode(4);
//        ListNode bNode5 = new ListNode(5);
        bNode1.next = bNode2;
        bNode2.next = bNode3;
        bNode3.next = bNode4;
//        bNode4.next = bNode5;

        ListNode listNode = middleNode(bNode1);
        System.out.println(listNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while (right != null && right.next != null){
            left = left.next;
            right = right.next.next;
        }
        return left;
    }
}
