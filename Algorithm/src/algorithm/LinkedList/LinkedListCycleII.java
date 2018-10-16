package algorithm.LinkedList;


/**
 *  142.Linked List Cycle II （环形链表II）
 *
 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

 说明：不允许修改给定的链表。

 进阶：
 你是否可以不用额外空间解决此题？

 解答：http://www.cnblogs.com/hiddenfox/p/3408931.html
 */
public class LinkedListCycleII {


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }



    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


}
