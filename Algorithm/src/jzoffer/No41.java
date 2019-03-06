package jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class No41 {

    /**
     * Q:数据流中的中位数
     * 如何得到一个数据流中的中位数？
     * 如果从数据流中读出奇数个数值，那么中位数就是所有值排序之后位于中间的数值。
     * 如果数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     */

    /**
     如果能够保证数据容器左边的数据都小于右边的数据，这样即使左、右两边内部的数据没有排序，
     也可以根据左边最大的数及右边最小的数得到中位数。
     如何快速从一个容器中找出最大数？
     用最大堆实现这个数据容器，因为位于堆顶的就是最大的数据。
     同样，也可以快速从最小堆中找出最小数。　　
     因此可以用如下思路来解决这个问题：用一个最大堆实现左边的数据容器，用最小堆实现右边的数据容器。
     往堆中插入一个数据的时间效率是O(logn).由于只需O(1)时间就可以得到位于堆顶的数据，因此得到中位数的时间效率是O(1).

     接下来考虑用最大堆和最小堆实现的一些细节。
     首先要保证数据平均分配到两个堆中，因此两个堆中数据的数目之差不能超过1（为了实现平均分配，可以在数据的总数目是偶数时把新数据插入到最小堆中，否则插入到最大堆中）。
     还要保证最大堆中里的所有数据都要小于最小堆中的数据。当数据的总数目是偶数时，按照前面分配的规则会把新的数据插入到最小堆中。如果此时新的数据比最大堆中的一些数据要小，怎么办呢？
     可以先把新的数据插入到最大堆中，接着把最大堆中的最大的数字拿出来插入到最小堆中。由于最终插入到最小堆的数字是原最大堆中最大的数字，这样就保证了最小堆中的所有数字都大于最大堆中的数字。
     当需要把一个数据插入到最大堆中，但这个数据小于最小堆里的一些数据时，这个情形和前面类似。
     */

    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private int N = 0;

    public void Insert(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }


    /**
     * 字符流中第一个不重复的字符
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     */

    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }









}
