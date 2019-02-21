package jzoffer;

import jzoffer.model.ListNode;

/**
 * 两个链表的第一个公共结点
 */
public class No52 {

    /**
     * 第一种：直接法
     * 在第一个链表上顺序遍历每个结点，每遍历到一个结点的时候，在第二个链表上顺序遍历每个结点。
     * 如果在第二个链表上有一个结点和第一个链表上的结点一样，说明两个链表在这个结点上重合，于是就找到了它们的公共结点。
     * 如果第一个链表的长度为m，第二个链表的长度为n，显然该方法的时间复杂度是O(mn） 。
     *
     * 第二种：使用栈
     * 所以两个有公共结点而部分重舍的链衰，拓扑形状看起来像一个Y， 而不可能像X（如图5.3 所示）。
     * 经过分析我们发现，如果两个链表有公共结点，那么公共结点出现在两个链表的尾部。
     * 如果我们从两个链衰的尾部开始往前比较，最后一个相同的结点就是我们要找的结点。
     * 在上述思路中，我们需要用两个辅助钱。如果链表的长度分别为m 和n，那么空间复杂度是O(m+n）。这种思路的时间复杂度也是O(m+n）。
     * 和最开始的蛮力法相比，时间效率得到了提高，相当于是用空间消耗换取了时间效率。
     *
     *
     * 第三种：先行法
     * 在图5.3 的两个链表中，我们可以先遍历一次得到它们的长度分别为5 和4， 也就是较长的链表与较短的链表相比多一个结点。
     * 第二次先在长的链表上走1 步，到达结点2。接下来分别从结点2 和结点4 出发同时遍历两个结点， 直到找到它们第一个相同的结点6，这就是我们想要的结果。
     * 第三种思路和第二种思路相比，时间复杂度都一样， 但我们不再需要辅助的拢，因此提高了空间效率。
     */

    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);

        int diff = length1 - length2;
        ListNode longListHead = head1;
        ListNode shortListHead = head2;

        if (diff < 0) {
            longListHead = head2;
            shortListHead = head1;
            diff = length2 - length1;
        }

        for (int i = 0; i < diff; i++) {
            longListHead = longListHead.next;
        }

        while (longListHead != null && shortListHead != null && longListHead != shortListHead) {
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }

        // 返回第一个相同的公共结点，如果没有返回null
        return longListHead;
    }

    private static int getListLength(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }

        return result;
    }


    //当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

}
