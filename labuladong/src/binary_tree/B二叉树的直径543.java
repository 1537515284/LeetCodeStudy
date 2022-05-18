package binary_tree;

public class B二叉树的直径543 {

    // 记录最大直径
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 对每个节点计算直径，求最大直径
        traverse(root);
        return maxDiameter;
    }

    // 遍历二叉树
    public  void traverse(TreeNode root){
        if(root == null)
            return;
        // 对每个节点计算直径
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax+rightMax;
        // 更新全局最大直径
        maxDiameter = Math.max(maxDiameter,myDiameter);

        traverse(root.left);
        traverse(root.right);
    }

    // 计算二叉树的最大深度
    public  int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }


    /*
       将计算直径的逻辑放在后序位置
     */

    // 记录最大直径
    int maxDiameter2 = 0;

    public int diameterOfBinaryTree2(TreeNode root) {
        maxDepth2(root);
        return maxDiameter2;
    }

    // 计算二叉树的最大深度
    public  int maxDepth2(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 后序位置，顺便计算最大直径
        maxDiameter2 = Math.max(left+right,maxDiameter2);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;

        int diameter = (new B二叉树的直径543()).diameterOfBinaryTree2(root);
        System.out.println(diameter);

    }
}
