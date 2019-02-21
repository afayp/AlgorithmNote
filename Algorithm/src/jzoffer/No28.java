package jzoffer;

import jzoffer.model.TreeNode;

/**
 * 对称的二叉树
 *
 * 请实现一个函数来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class No28 {

    /**
     * 通常我们有三种不同的二叉树遍历算法，即前序遍历、中序遍历和后序遍历。
     * 在这三种遍历算法中，都是先遍历左子结点再遍历右子结点。
     * 我们是否可以定义一种遍历算法，先遍历右子结点再遍历左子结点？
     * 比如我们针对前序遍历定义一种对称的遍历算法，即先遍历父节点，再遍历它的右子结点，最后遍历它的左子结点。
     *
     * 我们发现可以用过比较二叉树的前序遍历序列和对称前序遍历序列来判断二叉树是不是对称的。如果两个序列一样，那么二叉树就是对称的。
     */


    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }

}
