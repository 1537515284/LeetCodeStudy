package treeAndGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A二叉树的中序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;

        List<Integer> list = inorderTraversal2(root);
        System.out.println(list);

    }

    //中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return  res;
    }

    private static void inOrder(TreeNode node,List<Integer> res){

        if(node == null)
            return;
        inOrder(node.left,res);
        res.add(node.val);
        inOrder(node.right,res);
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }
}
