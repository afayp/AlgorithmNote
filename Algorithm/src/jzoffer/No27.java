package jzoffer;

import jzoffer.model.TreeNode;

/**
 * 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class No27 {

    /**
     * 先前序遍历这棵树的每个结点，
     * 如果遍历到的结点有子结点，就交换它的两个子结点。
     * 当交换完所有非叶子结点的左右子结点之后，就得到了树的镜像。
     */


    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}
