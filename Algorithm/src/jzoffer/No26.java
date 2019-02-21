package jzoffer;

import jzoffer.model.ListNode;
import jzoffer.model.TreeNode;

/**
 * 树的子结构
 * <p>
 * 输入两棵二叉树A 和B，判断B 是不是A 的子结构。
 */
public class No26 {

    /**
     * 要查找树A 中是否存在和树B 结构一样的子树，我们可以分成两步：
     * 第一步在树A 中找到和B 的根结点的值一样的结点R，
     * 第二步再判断树A 中以R 为根结点的子树是不是包含和树B 一样的结构。
     */

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubtreeWithRoot(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }

}
