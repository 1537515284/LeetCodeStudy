package treeAndGraph;

public class E二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        root.left = node2;
        root.right = node3;
        node2.right = node4;

        int i = (new E二叉搜索树中第K小的元素()).kthSmallest(root,2);
        System.out.println(i);
        int k = (new E二叉搜索树中第K小的元素()).kthSmallest2(root, 2);
        System.out.println(k);


    }

    int target = -1;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrderTraversal(root);
        return target;
    }

    public void  inOrderTraversal(TreeNode node){
        if(node == null)
            return;
        inOrderTraversal(node.left);
        if(--count == 0){
            target = node.val;
        }
        inOrderTraversal(node.right);
    }

    public int kthSmallest2(TreeNode root,int k){
        //先统计左子节点的个数
        int leftCount = countNodes(root.left);
        if(leftCount >= k){
            //如果左子节点的个数大于等于k，说明我们要找的元素就在左子节点中，
            //直接在左子节点中查找即可
            return kthSmallest2(root.left,k);
        }else if(leftCount+1 == k){
            //如果左子节点的个数加当前节点（1）正好等于k，说明根节点
            //就是要找到元素
            return root.val;
        }else {
            //否则要找的元素在右子节点中，到右子节点中查找
            return kthSmallest2(root.right,k-1-leftCount);
        }
    }

    //统计节点个数
    public int countNodes(TreeNode node){
        if(node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

}
