package algorithm.binarytree;


import java.util.Stack;

/**
 * 104.Maximum Depth of Binary Tree(二叉树的最大深度)
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaximumDepthofBinaryTree {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 递归 O(N)
//        int left_height = maxDepth(root.left);
//        int right_height = maxDepth(root.right);
//        return Math.max(left_height, right_height) + 1;

        // 迭代 O(N)
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if (node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;

    }



}
