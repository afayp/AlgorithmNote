package jzoffer;

import jzoffer.model.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 */
public class No25 {

    /**
     * Step1.定义一个指向新链表的指针，暂且让它指向NULL；
     Step2.比较两个链表的头结点，让较小的头结点作为新链表的头结点；
     Step3.有两种方法。
     ①递归比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点；
     ②循环比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点。直到有一个链表没有节点，然后将新链表的最后一个节点直接指向剩余链表的节点。
     */

    // 递归
    public ListNode merge(ListNode head1, ListNode head2) {

        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个结点为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        if (head1.val < head2.val) {
            // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
            head1.next = merge(head1.next,head2);
            return head1;
        }else {
            // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            head2.next = merge(head1,head2.next);
            return head2;
        }
    }

    public ListNode merge2(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个结点为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        // 创建一个临时结点，用于添加元素时方便
        ListNode head = new ListNode(-1);
        // 用于指向合并后的新链的尾结点
        ListNode cur = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            }else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }


        // 如果第一个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head1 != null) {
            cur.next = head1;
        }

        // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head2 != null) {
            cur.next = head2;
        }

        // 返回处理结果
        return head.next;
    }
}
