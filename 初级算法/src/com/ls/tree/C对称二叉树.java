package com.ls.tree;

import java.util.LinkedList;
import java.util.Queue;

public class C对称二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        boolean symmetric = isSymmetric2(root);
        System.out.println(symmetric);

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        // 从两个子节点开始判断
        return isSymmetricHelper(root.left,root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left,TreeNode right){
        // 如果左右子节点都为空，说明当前节点是叶子节点，返回true
        if(left == null && right == null)
            return true;
        // 如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相等，直接返回false
        if(left == null || right == null || left.val != right.val)
            return false;
        // 然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
        return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
    }

    // 非递归
    public static boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            // 每两个出队
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 如果都为空继续循环
            if(left == null && right == null)
                continue;
            // 如果一个为空一个不为空，说明不是对称的，直接返回false
            if(left == null ^ right== null)
                return false;
            // 如果这两个值不相同，也不是对称的，直接返回false
            if(left.val != right.val)
                return false;
            // 这里要注意入队的顺序，它会每两个两个的出队。
            // 左子节点的左子节点和右子节点的右子节点同时
            // 入队，因为它俩会同时比较。
            // 左子节点的右子节点和右子节点的左子节点同时入队，
            // 因为它俩会同时比较
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}


