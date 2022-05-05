package day05.doublePointer;

public class A链表的中间结点876 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        printListNode(node1);

        ListNode middleListNode = middleNode(node1);
        printListNode(middleListNode);
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

    /**
     * 打印链表
     */
    private static void printListNode(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

/**
 * 链表结点
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
