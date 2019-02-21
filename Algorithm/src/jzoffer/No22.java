package jzoffer;


import jzoffer.model.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k 个结点。
 * 为了符合大多数人的习惯，本题从1 开始计数，即链表的尾结点是倒数第1 个结点．
 * 例如一个链表有6 个结点，从头结点开始它们的值依次是1 、2、3、4、5 、6。这个个链表的倒数第3 个结点是值为4 的结点。
 */
public class No22 {

    /**
     * 为了实现只遍历链表一次就能找到倒数第k 个结点，我们可以定义两个指针。
     * 第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动；
     * 从第k 步开始，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在k-1 ， 当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k 个结点。
     */

    public ListNode findKthToTail(ListNode head, int k) {

        if (head == null) return null;

        // 指向头结点
        ListNode p1 = head;

        // 倒数第k个结点与倒数第一个结点相隔k-1个位置
        for (int i = 1; i < k; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            }else {
                return null;
            }
        }

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
