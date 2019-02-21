package structure.BinaryTree;

import java.util.*;

/**
 * 遍历
 * https://zh.wikipedia.org/wiki/%E6%A0%91%E7%9A%84%E9%81%8D%E5%8E%86
 *
 *
 * 分类：
 *      广度优先（breadth-first traversal）：先访问第一个子节点，再访问第二个子节点，最后访问父节点
 *      深度优先（depth-first traversal）：先访问子节点，再访问父节点，最后是第二个子节点
 *              ①、中序遍历:左子树——》根节点——》右子树
 *              ②、前序遍历:根节点——》左子树——》右子树
 *              ③、后序遍历:左子树——》右子树——》根节点
 *
 */
public class Traversal {



    //--------------------------------------- 广度优先搜索/层次遍历(BFS)----------------------------------------//
    public static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        // method 1 递归
        //bfsHelper(result,root,0);

        // method 2 队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int curL = 0;
        while(!queue.isEmpty()){
            List<Integer> levelRs = new ArrayList<Integer>();
            curL = queue.size();
            for(int i=0;i<curL;i++){
                TreeNode peek = queue.poll();
                levelRs.add(peek.val);
                if(peek.left!=null){
                    queue.offer(peek.left);
                }
                if(peek.right!=null){
                    queue.offer(peek.right);
                }
            }
            result.add(levelRs);
        }
        return result;
    }

    public void bfsHelper(List<List<Integer>> res, TreeNode root, int height) {
        if(root == null) return;
        if(height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        bfsHelper(res,root.left,height+1);
        bfsHelper(res,root.right,height+1);
    }



    //--------------------------------------- 后序遍历----------------------------------------//
    public List<Integer> postorderTraversal(TreeNode root) {

        // method 1
//        List<Integer> result = new ArrayList<>();
//        postorderHelper(root,result);

        // method 2
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            result.add(0,root.val);
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }
        return result;
    }

    public void postorderHelper(TreeNode root, List<Integer> result) {
        if(root != null) {
            if(root.left != null) {
                postorderHelper(root.left,result);
            }
            if(root.right != null) {
                postorderHelper(root.right,result);
            }
            result.add(root.val);
        }
    }


    //--------------------------------------- 中序遍历----------------------------------------//
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // method 1: recursion遍历
        //inorderHelper(root,res);

        // method 2: iteration use stack
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public void inorderHelper(TreeNode root, List<Integer> res) {
        if(root != null) {
            if(root.left != null) {
                inorderHelper(root.left,res);
            }
            res.add(root.val);
            if(root.right != null) {
                inorderHelper(root.right,res);
            }
        }
    }


    //--------------------------------------- 前序遍历----------------------------------------//
    // 1. 前序遍历 use list
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if (root == null) return pre;
        pre.add(root.val);
        pre.addAll(preorderTraversal1(root.left));
        pre.addAll(preorderTraversal1(root.right));
        return pre;
    }

    // 2. 前序遍历 use Helper method to have a List as paramater, so we can modify the parameter and don't have to instantiate a new List at each recursive call
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }
    public void preHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preHelper(root.left, list);
        preHelper(root.right, list);
    }

    // 3. 前序遍历 use stack
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if (root == null) return pre;
        Stack<TreeNode> tovisit = new Stack<>();
        tovisit.push(root);
        while (!tovisit.isEmpty()) {
            TreeNode visiting = tovisit.pop();
            pre.add(visiting.val);
            if (visiting.right != null) tovisit.push(visiting.right);
            if (visiting.left != null) tovisit.push(visiting.left);
        }
        return pre;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



}
