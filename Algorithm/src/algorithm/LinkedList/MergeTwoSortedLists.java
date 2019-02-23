package algorithm.LinkedList;

/**
 * Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 * Example
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 * <p>
 * 将两个排序链表合并为一个新的排序链表
 */
public class MergeTwoSortedLists {

    /**
     * 只需要从头开始比较已排序的两个链表，新链表指针每次指向值小的节点，依次比较下去，
     * 最后，当其中一个链表到达了末尾，我们只需要把新链表指针指向另一个没有到末尾的链表此时的指针即可。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 如果第一个链表为空，返回第二个链表头结点
        if (l1 == null) {
            return l2;
        }

        // 如果第二个结点为空，返回第一个链表头结点
        if (l2 == null) {
            return l1;
        }


        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return dummy.next;

    }


}
