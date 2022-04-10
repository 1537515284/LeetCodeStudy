package treeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Node connectNode = connect(root);

        List<List<Integer>> lists = levelOrder(connectNode);
        System.out.println(lists);

    }

    public static Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //每一层的数量
            int levelCount = queue.size();
            //前一个节点
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                //出队
                Node node = queue.poll();
                //如果pre为空就表示node节点是这一层的第一个
                //没有前一个节点指向它，否则就让前一个节点指向它
                if(pre != null)
                    pre.next = node;
                //然后再让当前节点成为前一个节点
                pre = node;
                // 左右子节点如果不为空就加入到队列中
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }

    // BFS
    public static List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();
        // 队列
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        // 根节点入队
        queue.add(root);
        // 如果队列不为空就继续循环
        while (!queue.isEmpty()){
            // BFS打印，levelNum表示的是每层的结点数
            int levelNum = queue.size();
            // subList存储的是每层的结点值
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                // 出队
                Node node = queue.poll();
                subList.add(node.val);
                // 左右子节点如果不为空就加入到队列中
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            // 把每层的节点值存储在res中
            res.add(subList);
        }
        return res;
    }
}
