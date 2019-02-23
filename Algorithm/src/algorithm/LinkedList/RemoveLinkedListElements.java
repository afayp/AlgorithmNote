package algorithm.LinkedList;

/**
 Remove all elements from a linked list of integers that have value val.
 Example
 Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 删除链表中等于给定值val的所有节点。
 */
public class RemoveLinkedListElements {

    /**
     * 删除链表中指定值，找到其前一个节点即可，将 next 指向下一个节点即可
     */

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return dummy.next;

    }
}
