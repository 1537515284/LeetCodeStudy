package linkList;

import java.math.BigInteger;

public class A两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1Node2 = new ListNode(4);
        ListNode l1Node3 = new ListNode(3);
        l1.next = l1Node2;
        l1Node2.next = l1Node3;

        ListNode l2 = new ListNode(5);
        ListNode l2Node2 = new ListNode(6);
        ListNode l2Node3 = new ListNode(4);
        l2.next = l2Node2;
        l2Node2.next = l2Node3;

        ListNode l3 = addTwoNumbers(l1, l2);
        ListNode.printNode(l3);

        ListNode node = addTwoNumbers4(l1, l2);
        ListNode.printNode(node);


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建一个哑节点，它的指针指向新链表的头节点
        ListNode dummyNode = new ListNode(0);
        //preNode表示当前节点的前一个节点
        ListNode preNode = dummyNode;
        //表示两个节点相加进位的值，加法最多只进一位，所以carry要么是1要么是0
        int carry = 0;
        //两个链表只要有一个不为空，或者有进位就一直循环
        while (l1 != null || l2 != null || carry != 0){
            //当前节点的累加值，需要加上前面进位的值
            int sum = carry;
            //如果第一个链表的当前节点不为空，加上第一个链表当前节点的值
            if(l1 != null){
                sum+=l1.val;
                l1 = l1.next;
            }
            //第二个链表，同上
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            //创建新的节点，preNode的next指针指向新的节点，因为链表节点
            //只能存储一位数字，所以这里要对sum求余，取个位数
            preNode.next = new ListNode(sum % 10);

            //如果sum大于等于10，说明有进位，carry为1
            //否则没有，carry为0
            carry = sum/10;
            //更新preNode
            preNode = preNode.next;
        }
        return dummyNode.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1,ListNode l2){
        ListNode dummyNode = new ListNode(0);
        helper(dummyNode,l1,l2,0);
        return dummyNode.next;
    }

    private static void helper(ListNode preNode,ListNode l1,ListNode l2,int carry){
        //只有两个链表都为空并且没有进位时才终止递归
        if(l1 == null && l2 == null && carry == 0)
            return;
        int sum = carry;
        //如果第一个链表的当前节点不为空，加上第一个链表当前节点的值
        if(l1 != null){
            sum+=l1.val;
            l1 = l1.next;
        }
        //第二个链表，同上
        if(l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }
        //创建新的节点
        preNode.next = new ListNode(sum%10);
        //更新carry
        carry = sum/10;
        //继续递归
        helper(preNode.next,l1,l2,carry);
    }

    public static ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("0");
        int sum = 0;
        while (l1 != null){
            a = a.add(new BigInteger( (l1.val * (int)Math.pow(10, sum++))+""));
            l1 = l1.next;
        }

        sum = 0;
        while (l2 != null){
             b=b.add(new BigInteger((l2.val*(int)Math.pow(10,sum++))+""));
            l2 = l2.next;
        }
        BigInteger c = a.add(b);
        String str = c.toString();

        ListNode res = new ListNode(0);
        ListNode node = res;
        for (int i = str.length()-1; i >= 0; i--) {
            node.next = new ListNode(str.charAt(i)-'0');
            node = node.next;
        }
        return res.next;
    }
}
