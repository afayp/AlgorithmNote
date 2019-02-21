package jzoffer;


import jzoffer.model.ListNode;

public class No18 {


    /**
     * Q1
     * 给定单向链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点。
     */

    /**
     * ① 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。
     * ② 否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
     * <p>
     * 综上，如果进行 N 次操作，那么大约需要操作节点的次数为 N-1+N=2N-1，
     * 其中 N-1 表示 N-1 个不是尾节点的每个节点以 O(1) 的时间复杂度操作节点的总次数，N 表示 1 个尾节点以 O(N) 的时间复杂度操作节点的总次数。
     * (2N-1)/N ~ 2，因此该算法的平均时间复杂度为 O(1)。
     */

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;
        if (tobeDelete.next != null) {
            // 要删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            ListNode cur = head;
            while (cur.next != tobeDelete)
                cur = cur.next;
            cur.next = null;
        }
        return head;
    }


    /**
     * Q2
     * 删除链表中重复的结点
     * 在一个排序的链表中，如何删除重复的结点？
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */

    /**
     * 解决这个问题的第一步是确定删除的参数。当然这个函数需要输入待删除链表的头结点。头结点可能与后面的结点重复，也就是说头结点也可能被删除，所以在链表头添加一个结点。
     * 接下来我们从头遍历整个链表。
     * 如果当前结点的值与下一个结点的值相同，那么它们就是重复的结点，都可以被删除。
     * 为了保证删除之后的链表仍然是相连的而没有中间断开，我们要把当前的前一个结点和后面值比当前结点的值要大的结点相连。
     * 我们要确保prev要始终与下一个没有重复的结点连接在一起。
     */
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }

}
