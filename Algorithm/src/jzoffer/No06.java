package jzoffer;

import jzoffer.model.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 */
public class No06 {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> result = new ArrayList<>();

        // 栈
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null) {
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        while (!stack.isEmpty()) {
//            result.add(stack.pop());
//        }

        //递归
        if (listNode != null) {
            result.addAll(printListFromTailToHead(listNode.next));
            result.add(listNode.val);
        }

        return result;
    }
}
