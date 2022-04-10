package linkList;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class C相交链表 {
    public static void main(String[] args) {

        // 相交的节点
        ListNode inNode1 = new ListNode(8);
        ListNode inNode2 = new ListNode(4);
        ListNode inNode3 = new ListNode(5);
        inNode1.next = inNode2;
        inNode2.next = inNode3;

        // l1链表
        ListNode l1 = new ListNode(4);
        ListNode l1Node2 = new ListNode(1);
        l1.next = l1Node2;
        l1Node2.next = inNode1;

        // l2链表
        ListNode l2 = new ListNode(5);
        ListNode l2Node2 = new ListNode(6);
        ListNode l2Node3 = new ListNode(1);
        l2.next = l2Node2;
        l2Node2.next = l2Node3;
        l2Node3.next = inNode1;

        ListNode intersectionNode = getIntersectionNode3(l1, l2);
        ListNode.printNode(intersectionNode);

        BigInteger bigInteger = new BigInteger("0");
        bigInteger = bigInteger.add(new BigInteger(1+""));
        System.out.println(bigInteger);


    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if(set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA,ListNode headB){
        //统计链表A和链表B的长度
        int lenA = length(headA);
        int lenB = length(headB);

        //如果节点长度不一样，节点多的先走，直到它们的长度相等
        while (lenA != lenB){
            if(lenA > lenB){
                headA = headA.next;
                lenA--;
            }else {
                headB = headB.next;
                lenB--;
            }
        }

        //然后开始比较，如果它俩不相等就一直往下走
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        //走到最后，最终会有两种可能，
        // 一种是headA为空，也就是说它俩不相交。
        //还有一种可能就是headA不为空，也就是说headA就是它们的交点
        return headA;
    }

    //统计链表的长度
    private static int length(ListNode node){
        int length = 0;
        while (node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    public static ListNode getIntersectionNode3(ListNode headA,ListNode headB){
        //tempA和tempB我们可以认为是A，B两个指针
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB){
            //如果指针tempA不为空，tempA就往后移一步
            //如果指针tempA为空，就让指针tempA指向headB
            tempA = tempA == null ? headB : tempA.next;
            //指针tempB同上
            tempB = tempB == null ? headA : tempB.next;
        }
        //tempA要么是空，要么是两链表的交点
        return tempA;
    }
}
