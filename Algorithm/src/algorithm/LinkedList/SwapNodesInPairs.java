package algorithm.LinkedList;


/**
 * 24.swap nodes in pairs
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.
 说明:

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curNode = dummy;

        while (curNode.next != null && curNode.next.next != null) {
            ListNode first = curNode.next;
            ListNode second = curNode.next.next;

            curNode.next = second;
            first.next = second.next;
            second.next = first;

            curNode = curNode.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode second = head.next;
        ListNode third = second.next;

        second.next = head;
        head.next = swapPairs2(third);

        return second;
    }


    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


}
