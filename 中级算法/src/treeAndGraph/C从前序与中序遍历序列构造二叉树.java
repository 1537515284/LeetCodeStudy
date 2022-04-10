package treeAndGraph;

import java.util.ArrayList;
import java.util.List;

public class C从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = buildTree2(preorder, inorder);
        List<Integer> list = A二叉树的中序遍历.inorderTraversal(node);
        System.out.println(list);


    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //把前序遍历的值和中序遍历的值放到list中
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return helper(preorderList,inorderList);
    }

    private static TreeNode helper(List<Integer> preorderList,List<Integer> inorderList){
        if(inorderList.size() == 0)
            return null;
        //前序遍历的第一个值就是根节点
        Integer rootVal = preorderList.remove(0);
        //创建根节点
        TreeNode root = new TreeNode(rootVal);
        //查看根节点在中序遍历中的位置，然后再把中序遍历的数组劈两半
        //前面部分是根节点左子树的所有值，后面部分是根节点右子树的所有值
        int mid = inorderList.indexOf(rootVal);
        //[0,mid)是左子树的所有值，inorderList.subList(0,mid)表示截取inorderList的值
        //截取的范围是[0,mid)，包含0不包含mid。
        root.left = helper(preorderList,inorderList.subList(0,mid));
        //[mid+1，inorderList.size())是右子树的所有值，
        //inorderList.subList(mid + 1, inorderList.size())表示截取inorderList的值
        //截取的范围是[mid+1，inorderList.size())，包含mid+1不包含inorderList.size()。
        root.right = helper(preorderList,inorderList.subList(mid+1,inorderList.size()));
        return root;
    }

    //双指针
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {

        return helper2(0,0,inorder.length,preorder,inorder);
    }

    public static TreeNode helper2(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
        if(preStart > preorder.length-1 || inStart > inEnd)
            return null;
        //创建节点
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        //找到当前节点root在中序遍历中的位置，然后再把数组分两半
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        root.left = helper2(preStart+1,inStart,index-1,preorder,inorder);
        root.right = helper2(preStart+index-inStart+1,index+1,inEnd,preorder,inorder);
        return root;
    }
}
