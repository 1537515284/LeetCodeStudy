package com.ls.tree;

import java.util.Stack;

public class B验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        boolean validBST = (new B验证二叉搜索树()).isValidBST2(root);
        System.out.println(validBST);

    }

    TreeNode prev;

    // 中序遍历递归
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        // 访问左子树
        if(!isValidBST(root.left))
            return false;
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点直接返回false
        if(prev != null && prev.val >= root.val)
            return false;
        prev = root;
        // 访问右子树
        return isValidBST(root.right);
    }


    // 中序遍历非递归
    public boolean isValidBST2(TreeNode root){
        if(root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val)
                return false;
            // 保存前一个访问的节点
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST3(TreeNode root){
        return isValidBST3(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST3(TreeNode root,long minVal,long maxVal){
        if(root == null)
            return true;
        //每个节点如果超过这个范围，直接返回false
        if(root.val >= maxVal || root.val <= minVal)
            return false;
        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        return isValidBST3(root.left,minVal,root.val) && isValidBST3(root.right, root.val,maxVal);
    }

}
