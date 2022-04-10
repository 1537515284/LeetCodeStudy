package treeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B二叉树的锯齿形层次遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        //创建队列，保存节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);    //先把根节点加入队列
        boolean leftToRight = true; //第一步先从左边开始打印
        while (!queue.isEmpty()){
            //记录每次节点的值
            List<Integer> level = new ArrayList<>();
            //统计这一层节点数
            int count = queue.size();
            //遍历这一层的所有节点，把它们全部从队列中移出
            //顺便把它们的值加入到集合level中，接着再把它们的子节点(如果有)，加到队列中
            for (int i = 0; i < count; i++) {
                // 节点头部出队
                TreeNode node = queue.poll();
                // 判断打印方向
                if(leftToRight) {
                    // 如果是从左边开始打印，把访问的节点值加入到level的末尾
                    level.add(node.val);
                } else {
                    // 如果是右边开始打印，每次要把访问的节点值 加入到列表的头部
                    level.add(0, node.val);
                }
                // 左右子节点如果不为空就加入到队列中
                if(node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //把这一层的节点加入到集合res中
            res.add(level);
            //改变下次访问的方向
            leftToRight = !leftToRight;
        }
        return res;
    }
}
