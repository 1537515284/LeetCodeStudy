package level01.sixthDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N叉树的前序遍历589 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = Arrays.asList(
                new Node(3,Arrays.asList(new Node(5,new ArrayList<>()),new Node(6,new ArrayList<>()))),
                new Node(2,new ArrayList<>()),
                new Node(4,new ArrayList<>()));
        List<Integer> preorder = (new N叉树的前序遍历589()).preorder(root);
        System.out.println(preorder);

    }


    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(Node root,List<Integer> res){
        if(root == null)
            return;
        res.add(root.val);
        for (Node child : root.children) {
            helper(child,res);
        }
    }
}
