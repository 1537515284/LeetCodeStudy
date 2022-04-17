package design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println();

    }

}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root,"");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String > dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    private String rserialize(TreeNode root,String str){
        if(root == null){
            str += "#,";
        }else {
            str += root.val+",";
            str = rserialize(root.left,str);
            str = rserialize(root.right,str);
        }
        return str;
    }

    private TreeNode rdeserialize(List<String > dataList){
        if(dataList.get(0).equals("#")){
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
