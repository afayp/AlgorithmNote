package jzoffer;

/**
 * 二进制中 1 的个数
 *
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 *
 * 例如把9表示成二进制1001，有2位1。因此如果输入9，该函数输出2。
 */
public class No15 {

    /**
     * n&(n-1)
     该位运算去除 n 的位级表示中最低的那一位。

     n       : 10110100
     n-1     : 10110011
     n&(n-1) : 10110000
     时间复杂度：O(M)，其中 M 表示 1 的个数。
     */


    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

}
