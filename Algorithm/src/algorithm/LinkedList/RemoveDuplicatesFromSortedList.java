package algorithm.LinkedList;

/**
 * Remove-Duplicates-from-Sorted-List

 Given a sorted linked list, delete all duplicates such that each element appear only once.
 For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.

 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 */
public class RemoveDuplicatesFromSortedList {


    /**
     * 遍历之，遇到当前节点和下一节点的值相同时，删除下一节点，
     * 并将当前节点next值指向下一个节点的next,
     * 当前节点首先保持不变，直到相邻节点的值不等时才移动到下一节点。
     */

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
