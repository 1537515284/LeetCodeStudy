package level01.thirdDay;

public class 合并两个有序链表21 {

    public static void main(String[] args) {
        ListNode aNode1 = new ListNode(1);
        ListNode aNode2 = new ListNode(3);
        ListNode aNode3 = new ListNode(4);
        aNode1.next = aNode2;
        aNode2.next = aNode3;

        ListNode bNode1 = new ListNode(1);
        ListNode bNode2 = new ListNode(3);
        ListNode bNode3 = new ListNode(5);
        ListNode bNode4 = new ListNode(7);
        bNode1.next = bNode2;
        bNode2.next = bNode3;
        bNode3.next = bNode4;

        ListNode listNode = mergeTwoLists(aNode1, bNode1);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = list1;
        ListNode right = list2;
        ListNode res = new ListNode();
        ListNode head = res;
        while (left != null && right != null){
            if(left.val <= right.val){
                head.next = left;
                left = left.next;
            }else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        head.next = left == null ? right : left;
        return res.next;
    }
}
