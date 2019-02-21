package jzoffer;

import jzoffer.model.ListNode;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class No24 {


    /**
     * ①遍历。将指向下一个节点的指针指向上一个节点。
     * ②递归。先让指向下一个节点的指针为空，然后递归调用，最后再将指向下一个节点的指针指向上一个节点。
     */


    // 遍历
    public ListNode reverseHead(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        head.next = null;
        head = pre;
        return head;
    }

    // 递归
    public ListNode reverseHead2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode nextNode = head.next;
        head.next = null;
        ListNode newHead = reverseHead2(nextNode);
        nextNode.next = head;
        return newHead;
    }




}
