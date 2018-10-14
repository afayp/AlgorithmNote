package algorithm.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 141.Linked List Cycle
 *
 给定一个链表，判断链表中是否有环。

 进阶：
 你能否不使用额外空间解决此题？
 */
public class LinkedListCycle {


    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    /**
     * HashSet
     *
     * Time complexity : O(n). We visit each of the nn elements in the list at most once. Adding a node to the hash table costs only O(1)O(1) time.
     * Space complexity: O(n). The space depends on the number of elements added to the hash table, which contains at most nn elements.
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }



    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
