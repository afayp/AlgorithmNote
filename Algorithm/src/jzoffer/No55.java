package jzoffer;

import jzoffer.model.TreeNode;


public class No55 {

    /**
     * Q:二叉树的深度
     *输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */

    /**
     * 如果一棵树只有一个结点，它的深度为1。
     * 如果根结点只有左子树而没有右子树， 那么树的深度应该是其左子树的深度加1，
     * 同样如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1.
     * 如果既有右子树又有左子树， 那该树的深度就是其左、右子树深度的较大值再加1。
     */

    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

    /**
     * Q: 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意结点的左右子树的深度相差不超过1 ，那么它就是一棵平衡二叉树。
     */

    /**
     * 最直接的做法，遍历每个结点，借助一个获取树深度的递归函数，根据该结点的左右子树高度差判断是否平衡，然后递归地对左右子树进行判断。
     */

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 这种做法有很明显的问题，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
     * 如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
     * 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
     */

    public boolean IsBalanced_Solution2(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }


}
