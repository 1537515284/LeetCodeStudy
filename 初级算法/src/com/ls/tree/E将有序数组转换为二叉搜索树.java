package com.ls.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode node = sortedArrayToBST2(nums);
        List<List<Integer>> lists = D二叉树的层序遍历.levelOrder(node);
        System.out.println(lists);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private static TreeNode sortedArrayToBST(int[] num,int start,int end){
        if(start > end)
            return null;
        int mid = (start+end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num,start,mid-1);
        root.right = sortedArrayToBST(num,mid+1,end);
        return root;
    }

    // BFS解决
    public static TreeNode sortedArrayToBST2(int[] nums){
        if(nums == null || nums.length == 0)
            return null;
        Queue<int[]> rangeQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        int lo = 0;
        int hi = nums.length -1;
        int mid = (lo+hi) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        rangeQueue.add(new int[]{lo,mid-1});
        rangeQueue.add(new int[]{mid+1,hi});
        nodeQueue.add(node);
        nodeQueue.add(node);
        while (!rangeQueue.isEmpty()){
            int[] range = rangeQueue.poll();
            TreeNode currentNode = nodeQueue.poll();
            lo = range[0];
            hi = range[1];
            if(lo > hi)
                continue;
            mid = (lo+hi) >> 1;
            int midValue = nums[mid];
            TreeNode newNode = new TreeNode(midValue);
            if(midValue > currentNode.val)
                currentNode.right = newNode;
            else
                currentNode.left = newNode;
            if(lo < hi){
                rangeQueue.add(new int[]{lo,mid-1});
                rangeQueue.add(new int[]{mid+1,hi});
                nodeQueue.add(newNode);
                nodeQueue.add(newNode);
            }
        }
        return node;
    }
}
