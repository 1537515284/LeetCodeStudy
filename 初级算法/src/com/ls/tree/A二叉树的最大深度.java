package com.ls.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class A二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = null;
        TreeNode node4 = null;
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        int depth = maxDepth3(root);
        System.out.println(depth);

    }

//    public static int maxDepth(TreeNode root) {
//        if(root == null)
//            return 0;
//        int i;
//        int j;
//        if(root.left != null)
//            i = maxDepth(root.left);
//        else
//            i = 0;
//        if(root.right != null)
//            j = maxDepth(root.right);
//        else
//            j = 0;
//        return i>j ? i+1 : j+1;
//    }

    public static int maxDepth(TreeNode root){
        return root == null ? 0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    // BFS
    public static int maxDepth2(TreeNode root){
        if(root == null)
            return 0;
        // 创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()){
            // 每层的个数
            int size = deque.size();
            while (size-- > 0){
                TreeNode cur = deque.pop();
                if(cur.left != null)
                    deque.addLast(cur.left);
                if(cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }

    // DFS
    public static int maxDepth3(TreeNode root){
        if(root == null)
            return 0;
        // stack记录的是节点，而level中的元素和stack中的元素
        // 是同时入栈同时出栈，并且level记录的是节点在第几层
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        int max = 0;
        while (!stack.isEmpty()){
            // stack中的元素和level中的元素同时出栈
            TreeNode node = stack.pop();
            int temp = level.pop();
            max = Math.max(temp,max);
            if(node.left != null){
                // 同时入栈
                stack.push(node.left);
                level.push(temp+1);
            }
            if(node.right != null){
                // 同时入栈
                stack.push(node.right);
                level.push(temp+1);
            }
        }
        return max;
    }
}
